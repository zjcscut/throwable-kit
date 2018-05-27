package club.throwable.kit.support;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:01
 */
@Component
public class PreferredSizeProcessor {

	public void applyPreferredSize(JFrame jFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds((int) (screenSize.width * 0.1),
				(int) (screenSize.height * 0.08),
				(int) (screenSize.width * 0.8),
				(int) (screenSize.height * 0.8));
		Dimension preferSize = new Dimension((int) (screenSize.width * 0.8),
				(int) (screenSize.height * 0.8));
		jFrame.setPreferredSize(preferSize);
	}
}
