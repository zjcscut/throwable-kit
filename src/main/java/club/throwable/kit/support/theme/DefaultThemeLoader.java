package club.throwable.kit.support.theme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:42
 */
@Slf4j
@Component
public class DefaultThemeLoader implements ThemeLoader {

	@Override
	public void loadTheme(LookAndFeel newLookAndFeel) {
		try {
			UIManager.setLookAndFeel(newLookAndFeel);
		} catch (Exception e) {
			log.error("Load theme error,theme:{}", newLookAndFeel, e);
		}
	}

	@Override
	public void loadTheme(String className) {
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			log.error("Load theme error,theme:{}", className, e);
		}
	}
}
