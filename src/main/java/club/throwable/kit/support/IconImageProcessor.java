package club.throwable.kit.support;

import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.utils.OsUtils;
import com.apple.eawt.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:11
 */
@Component
public class IconImageProcessor {

	@Autowired
	private ClassPathImageLoader classPathImageLoader;

	public void applyIconImageIfNecessary(JFrame jFrame) {
		Image image = classPathImageLoader.loadImage(UiConstant.IMAGE_ICON_PATH);
		if (null != image) {
			jFrame.setIconImage(image);
			if (OsUtils.INSTANCE.isMacOs()) {
				Application application = Application.getApplication();
				application.setDockIconImage(image);
			}
		}
	}
}
