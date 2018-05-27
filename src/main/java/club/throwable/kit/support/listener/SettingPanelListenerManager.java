package club.throwable.kit.support.listener;

import club.throwable.kit.model.GlobalSettingProperty;
import club.throwable.kit.support.configuration.GlobalPropertyManager;
import club.throwable.kit.support.theme.GlobalFontLoader;
import club.throwable.kit.support.theme.ThemeManager;
import club.throwable.kit.ui.MainWindow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 9:00
 */
@Slf4j
@Component
public class SettingPanelListenerManager {

	@Autowired
	private GlobalPropertyManager globalPropertyManager;

	@Autowired
	private ThemeManager themeManager;

	@Autowired
	private GlobalFontLoader globalFontLoader;

	public void addSaveSettingButtonListener(JFrame mainFrame, MainWindow mainWindow) {
		mainWindow.getSaveSettingButton().addActionListener(event -> {
			try {
				GlobalSettingProperty settings = globalPropertyManager.getGlobalSettingProperty();
				Object theme = mainWindow.getSettingThemeComboBox().getSelectedItem();
				if (null != theme) {
					settings.setTheme(theme.toString());
				}
				Object fontName = mainWindow.getSettingFontNameComboBox().getSelectedItem();
				if (null != fontName) {
					settings.setFont(fontName.toString());
				}
				Object fontSize = mainWindow.getSettingFontSizeComboBox().getSelectedItem();
				if (null != fontSize) {
					settings.setFontSize(Integer.valueOf(fontSize.toString()));
				}
				globalPropertyManager.saveGlobalSettingProperty(settings);
				themeManager.initializeTheme();
				globalFontLoader.loadGlobalFont();
				SwingUtilities.updateComponentTreeUI(mainFrame);
				SwingUtilities.updateComponentTreeUI(mainWindow.getTabbedPane());
				JOptionPane.showMessageDialog(mainWindow.getSettingPanel(), "保存成功！\n\n部分细节将在下次启动时生效！\n\n", "成功",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				log.error("Save settings error", e);
				JOptionPane.showMessageDialog(mainWindow.getSettingPanel(), "保存失败！\n\n" + e.getMessage(), "失败",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
