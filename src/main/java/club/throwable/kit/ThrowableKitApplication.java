package club.throwable.kit;

import club.throwable.kit.common.constant.ConfigurationConstant;
import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.common.constant.VersionConstant;
import club.throwable.kit.support.IconImageProcessor;
import club.throwable.kit.support.PanelContainerInitializer;
import club.throwable.kit.support.PreferredSizeProcessor;
import club.throwable.kit.support.listener.ListenerManagerFacade;
import club.throwable.kit.support.theme.GlobalFontLoader;
import club.throwable.kit.support.theme.ThemeManager;
import club.throwable.kit.ui.LoadingWindow;
import club.throwable.kit.ui.MainWindow;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/17 23:20
 */
@Slf4j
@SpringBootApplication
public class ThrowableKitApplication {

	private static final Executor EXECUTOR = Executors.newSingleThreadExecutor();

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ThrowableKitApplication.class)
				.web(WebApplicationType.NONE)
				.headless(Boolean.FALSE)
				.run(args);
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		PreferredSizeProcessor preferredSizeProcessor = beanFactory.getBean(PreferredSizeProcessor.class);
		IconImageProcessor iconImageProcessor = beanFactory.getBean(IconImageProcessor.class);
		ThemeManager themeManager = beanFactory.getBean(ThemeManager.class);
		GlobalFontLoader globalFontLoader = beanFactory.getBean(GlobalFontLoader.class);
		//初始化主题样式
		themeManager.initializeTheme();
		LoadingWindow loadingWindow = new LoadingWindow();
		//适配Mac的Dock
		iconImageProcessor.applyIconImageIfNecessary(loadingWindow);
		//去掉边框
		loadingWindow.setVisible(Boolean.TRUE);
		JProgressBar progressBar = loadingWindow.getLoadingProgressBar();
		JLabel label = loadingWindow.getLoadingProcessingLabel();
		LoadingHolder holder = new LoadingHolder();
		EXECUTOR.execute(() -> {
			try {
				label.setText("刷新Spring上下文");
				progressBar.setValue(20);
				Thread.sleep(450);
				//初始化字体样式
				globalFontLoader.loadGlobalFont();
				label.setText("初始化主题样式和字体样式");
				progressBar.setValue(40);
				Thread.sleep(450);
				JFrame mainFrame = new JFrame(VersionConstant.APPLICATION_NAME);
				//适配Mac的Dock
				iconImageProcessor.applyIconImageIfNecessary(mainFrame);
				//适配屏幕大小
				preferredSizeProcessor.applyPreferredSize(mainFrame);
				label.setText("适配屏幕大小和Mac的Dock样式");
				progressBar.setValue(60);
				Thread.sleep(450);
				MainWindow mainWindow = new MainWindow();
				beanFactory.registerSingleton(UiConstant.MAIN_WINDOW, mainWindow);
				beanFactory.registerSingleton(UiConstant.MAIN_FRAME, mainFrame);
				mainFrame.setContentPane(mainWindow.getMainPanel());
				//取消主窗口的关闭事件
				mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				mainFrame.pack();
				//注册核心组件Bean
				registerRequiredComponents(beanFactory);
				label.setText("注册核心组件Bean");
				progressBar.setValue(80);
				Thread.sleep(450);
				//注册监听器
				ListenerManagerFacade listenerManagerFacade = beanFactory.getBean(ListenerManagerFacade.class);
				listenerManagerFacade.registerListeners();
				//初始化所有面板
				PanelContainerInitializer initializer = beanFactory.getBean(PanelContainerInitializer.class);
				initializer.processInitializingPanels();
				label.setText("注册监听器并且初始化所有面板");
				progressBar.setValue(100);
				Thread.sleep(450);
				holder.setMainFrame(mainFrame);
			} catch (Exception e) {
				//一般这里应该不会出现问题
				log.error(e.getMessage(), e);
			}
		});
		//卡住加载页面,虽然有点low,但是暂时想不到其他方法
		Thread.sleep(ConfigurationConstant.LOADING_SLEEP_MILLION_SECONDS);
		//卸载加载页面
		loadingWindow.dispose();
		//显示主窗口
		holder.getMainFrame().setVisible(Boolean.TRUE);
	}


	@Data
	private static class LoadingHolder {

		JFrame mainFrame;
	}

	private static void registerRequiredComponents(DefaultListableBeanFactory beanFactory) {
		ListenerManagerFacade listenerManagerFacade = new ListenerManagerFacade();
		beanFactory.autowireBean(listenerManagerFacade);
		beanFactory.registerSingleton("listenerManagerFacade", listenerManagerFacade);
		PanelContainerInitializer panelContainerInitializer = new PanelContainerInitializer();
		beanFactory.autowireBean(panelContainerInitializer);
		beanFactory.registerSingleton("panelContainerInitializer", panelContainerInitializer);
	}
}
