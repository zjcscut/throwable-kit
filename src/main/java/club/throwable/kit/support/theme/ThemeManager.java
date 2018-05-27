package club.throwable.kit.support.theme;

import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.support.configuration.GlobalPropertyManager;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:46
 */
@Component
public class ThemeManager {

	private static final Map<String, String> THEME_MAPPINGS = new HashMap<>();

	static {
		THEME_MAPPINGS.put("系统默认", UIManager.getSystemLookAndFeelClassName());
		THEME_MAPPINGS.put("Windows", WindowsLookAndFeel.class.getName());
		THEME_MAPPINGS.put("Nimbus", NimbusLookAndFeel.class.getName());
		THEME_MAPPINGS.put("Metal", MetalLookAndFeel.class.getName());
		THEME_MAPPINGS.put("Motif", MotifLookAndFeel.class.getName());
		THEME_MAPPINGS.put("Darcula", UiConstant.DARCULA_THEME);
	}

	@Autowired
	private ThemeLoader themeLoader;

	@Autowired
	private GlobalPropertyManager globalPropertyManager;

	public void initializeTheme() throws Exception {
		String theme = globalPropertyManager.getTheme();
		String themeClass = THEME_MAPPINGS.get(theme);
		if (null != themeClass) {
			themeLoader.loadTheme(themeClass);
		} else {
			themeLoader.loadTheme(UiConstant.DARCULA_THEME);
		}
	}
}
