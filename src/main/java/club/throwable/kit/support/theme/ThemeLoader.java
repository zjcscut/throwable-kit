package club.throwable.kit.support.theme;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:40
 */
public interface ThemeLoader {

	 void loadTheme(LookAndFeel newLookAndFeel);

	 void loadTheme(String className);
}
