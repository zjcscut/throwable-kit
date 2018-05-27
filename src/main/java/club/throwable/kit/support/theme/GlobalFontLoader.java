package club.throwable.kit.support.theme;

import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.model.GlobalSettingProperty;
import club.throwable.kit.support.configuration.GlobalPropertyManager;
import club.throwable.kit.utils.OsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 0:19
 */
@Component
public class GlobalFontLoader {

	@Autowired
	private GlobalPropertyManager globalPropertyManager;

	public void loadGlobalFont() {
		GlobalSettingProperty settings = globalPropertyManager.getGlobalSettingProperty();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//低分辨率屏幕
		if (screenSize.width < UiConstant.LOW_DPI_LIMIT && null == settings.getLowDpiScreen()) {
			settings.setLowDpiScreen(Boolean.TRUE);
			settings.setFontSize(UiConstant.DEFAULT_CHANGE_FONT_SIZE);
			globalPropertyManager.saveGlobalSettingProperty(settings);
		}
		//高分辨率屏幕
		if (OsUtils.INSTANCE.isMacOs() && null == settings.getHighDpiScreen()) {
			settings.setHighDpiScreen(Boolean.TRUE);
			settings.setFontSize(UiConstant.DEFAULT_CHANGE_FONT_SIZE);
			globalPropertyManager.saveGlobalSettingProperty(settings);
		}
		Font font = new Font(settings.getFont(), Font.PLAIN, settings.getFontSize());
		FontUIResource fontUIResource = new FontUIResource(font);
		for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontUIResource);
			}
		}
	}
}
