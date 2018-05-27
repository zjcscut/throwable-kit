package club.throwable.kit.support;

import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.common.constant.VersionConstant;
import club.throwable.kit.model.GlobalSettingProperty;
import club.throwable.kit.support.configuration.GlobalPropertyManager;
import club.throwable.kit.ui.MainWindow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 2:03
 */
@Slf4j
public class PanelContainerInitializer {

	@Autowired
	@Qualifier(value = UiConstant.MAIN_WINDOW)
	private MainWindow mainWindow;

	@Autowired
	private GlobalPropertyManager globalPropertyManager;

	@Autowired
	private JsonPanelInitializer jsonPanelInitializer;

	public void processInitializingPanels() {
		GlobalSettingProperty settings = globalPropertyManager.getGlobalSettingProperty();
		initializeAboutPanel();
		initializeHelpPanel();
		initializeJsonPanel();
		initializeSettingPanel(settings);
	}

	private void initializeAboutPanel() {
		JLabel versionLabel = mainWindow.getVersionLabel();
		versionLabel.setText(VersionConstant.CURRENT_VERSION);
	}

	private void initializeJsonPanel() {
		jsonPanelInitializer.initializeJsonPanel(mainWindow);
	}

	private void initializeHelpPanel(){
		JTextPane helpTextPane = mainWindow.getHelpTextPane();
		helpTextPane.setEnabled(Boolean.FALSE);
		HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
		helpTextPane.setEditorKit(htmlEditorKit);
		StyleSheet styleSheet = htmlEditorKit.getStyleSheet();
		styleSheet.addRule("h2{color:#ffe484;background: transparent none;border: 1px solid #ffe484;padding: 0.375rem 0.75rem;border-radius: 0.25rem;}");
		helpTextPane.setContentType("text/html; charset=utf-8");
		try {
			helpTextPane.setPage(new ClassPathResource("/static/view/help.html").getURL());
		}catch (Exception e){
            log.error("Load help view failed", e);
		}
	}

	private void initializeSettingPanel(GlobalSettingProperty settings) {
		JCheckBox autoCheckUpdateCheckBox = mainWindow.getAutoCheckUpdateCheckBox();
		if (null != settings.getAutoCheckUpdate()) {
			autoCheckUpdateCheckBox.setSelected(settings.getAutoCheckUpdate());
		}
		JComboBox settingThemeComboBox = mainWindow.getSettingThemeComboBox();
		if (null != settings.getTheme()) {
			settingThemeComboBox.setSelectedItem(settings.getTheme());
		}
		JComboBox settingFontNameComboBox = mainWindow.getSettingFontNameComboBox();
		if (null != settings.getFont()) {
			settingFontNameComboBox.setSelectedItem(settings.getFont());
		}
		JComboBox settingFontSizeComboBox = mainWindow.getSettingFontSizeComboBox();
		if (null != settings.getFontSize()) {
			settingFontSizeComboBox.setSelectedItem(String.valueOf(settings.getFontSize()));
		}
	}
}
