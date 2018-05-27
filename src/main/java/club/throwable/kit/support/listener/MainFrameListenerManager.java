package club.throwable.kit.support.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 22:44
 */
@Slf4j
@Component
public class MainFrameListenerManager {

	public void addWindowListener(JFrame jFrame) {
		jFrame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				log.debug("Main frame is closing...");
				jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
	}
}
