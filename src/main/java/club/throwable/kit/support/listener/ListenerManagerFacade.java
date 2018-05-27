package club.throwable.kit.support.listener;

import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 2:08
 */
public class ListenerManagerFacade {

	@Autowired
	private JsonPanelListenerManager jsonPanelListenerManager;

	@Autowired
	private MainFrameListenerManager mainFrameListenerManager;

	@Autowired
	private SettingPanelListenerManager settingPanelListenerManager;

	@Autowired
	private AboutPanelListenerManager aboutPanelListenerManager;

	@Autowired
	@Qualifier(value = UiConstant.MAIN_FRAME)
	private JFrame mainFrame;

	@Autowired
	@Qualifier(value = UiConstant.MAIN_WINDOW)
	private MainWindow mainWindow;

	public void registerListeners() {
		jsonPanelListenerManager.addOpenJsonParserButtonListener(mainWindow);
		mainFrameListenerManager.addWindowListener(mainFrame);
		settingPanelListenerManager.addSaveSettingButtonListener(mainFrame, mainWindow);
		aboutPanelListenerManager.addAboutPanelListener(mainWindow);
	}
}
