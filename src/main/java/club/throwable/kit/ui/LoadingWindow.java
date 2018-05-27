package club.throwable.kit.ui;

import java.awt.*;
import com.intellij.uiDesigner.core.*;
import lombok.Getter;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 9:29
 */
@Getter
public class LoadingWindow extends JFrame{

	public LoadingWindow() {
		initComponents();
		Dimension dimension = new Dimension(550,450);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		loadingPanel = new JPanel();
		this.getContentPane().add(loadingPanel);
		Spacer hSpacer1 = new Spacer();
		Spacer hSpacer2 = new Spacer();
		loadingApplicationNameLabel = new JLabel();
		loadingProcessingLabel = new JLabel();
		loadingProgressBar = new JProgressBar();
		loadingLabel = new JLabel();

		//======== loadingPanel ========
		{
			loadingPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
			loadingPanel.add(hSpacer1, new GridConstraints(0, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
				GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK,
				null, null, null));
			loadingPanel.add(hSpacer2, new GridConstraints(0, 2, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
				GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK,
				null, null, null));

			//---- loadingApplicationNameLabel ----
			loadingApplicationNameLabel.setFont(new Font("Consolas", Font.BOLD, 16));
			loadingApplicationNameLabel.setText("Throwable-Kit");
			loadingPanel.add(loadingApplicationNameLabel, new GridConstraints(1, 1, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED,
				GridConstraints.SIZEPOLICY_FIXED,
				null, null, null));

			//---- loadingProcessingLabel ----
			loadingProcessingLabel.setText("\u6b63\u5728\u52a0\u8f7d");
			loadingPanel.add(loadingProcessingLabel, new GridConstraints(2, 1, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED,
				GridConstraints.SIZEPOLICY_FIXED,
				null, null, null));
			loadingPanel.add(loadingProgressBar, new GridConstraints(3, 1, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
				GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
				GridConstraints.SIZEPOLICY_FIXED,
				null, null, null));

			//---- loadingLabel ----
			loadingLabel.setIcon(new ImageIcon(getClass().getResource("/static/img/logo-lg.png")));
			loadingLabel.setText("");
			loadingPanel.add(loadingLabel, new GridConstraints(0, 1, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED,
				GridConstraints.SIZEPOLICY_FIXED,
				null, null, null));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel loadingPanel;
	private JLabel loadingApplicationNameLabel;
	private JLabel loadingProcessingLabel;
	private JProgressBar loadingProgressBar;
	private JLabel loadingLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
