package club.throwable.kit.support.listener;

import club.throwable.kit.common.constant.VersionConstant;
import club.throwable.kit.ui.MainWindow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 18:23
 */
@Slf4j
@Component
public class AboutPanelListenerManager {

	public void addAboutPanelListener(MainWindow mainWindow){
		addCheckUpdateButtonListener(mainWindow.getAboutPanel(),mainWindow.getCheckUpdateButton());
		addClickPowerByLabelListener(mainWindow.getPowerByLabel());
		addClickForkLabelListener(mainWindow.getForkLabel());
	}

	private void addCheckUpdateButtonListener(JPanel aboutPanel,JButton checkUpdateButton){
		checkUpdateButton.addActionListener(event -> {
			JOptionPane.showMessageDialog(aboutPanel, "暂时不支持更新功能",
					"提醒", JOptionPane.WARNING_MESSAGE);
		});
	}

	private void addClickPowerByLabelListener(JLabel powerByLabel){
		powerByLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(VersionConstant.BLOG_URL));
				}catch (Exception e){
					log.error("Click power by label to open browser failed", e);
				}
			}
		});
	}

	private void addClickForkLabelListener(JLabel forkByLabel){
		forkByLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(VersionConstant.GITHUB_REPOSITORY_URL));
				}catch (Exception e){
					log.error("Click fork label to open browser failed", e);
				}
			}
		});
	}
}
