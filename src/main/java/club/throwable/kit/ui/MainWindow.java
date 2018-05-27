package club.throwable.kit.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 22:36
 */
@Getter
public class MainWindow {

	public MainWindow() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mainPanel = new JPanel();
		tabbedPane = new JTabbedPane();
		aboutPanel = new JPanel();
		logoLabel = new JLabel();
		appNameLabel = new JLabel();
		versionLabel = new JLabel();
		powerByLabel = new JLabel();
		forkLabel = new JLabel();
		checkUpdateButton = new JButton();
		helpPanel = new JPanel();
		helpScrollPane = new JScrollPane();
		helpTextPane = new JTextPane();
		jsonPanel = new JPanel();
		settingPanel = new JPanel();
		settingScrollPane = new JScrollPane();
		settingInnerPanel = new JPanel();
		normalPanel = new JPanel();
		autoCheckUpdateCheckBox = new JCheckBox();
		Spacer hSpacer2 = new Spacer();
		Spacer vSpacer2 = new Spacer();
		facePanel = new JPanel();
		Spacer hSpacer3 = new Spacer();
		settingThemeComboBox = new JComboBox<>();
		themeLabel = new JLabel();
		Spacer vSpacer3 = new Spacer();
		fontLabel = new JLabel();
		settingFontNameComboBox = new JComboBox<>();
		fontSizeLabel = new JLabel();
		settingFontSizeComboBox = new JComboBox<>();
		updatePanel = new JPanel();
		saveSettingButton = new JButton();
		Spacer hSpacer4 = new Spacer();
		Spacer vSpacer4 = new Spacer();

		//======== mainPanel ========
		{
			mainPanel.setMinimumSize(new Dimension(700, 800));
			mainPanel.setOpaque(false);
			mainPanel.setPreferredSize(new Dimension(700, 800));
			mainPanel.setRequestFocusEnabled(false);
			mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

			//======== tabbedPane ========
			{

				//======== aboutPanel ========
				{
					aboutPanel.setLayout(new GridLayoutManager(6, 1, new Insets(10, 10, 10, 10), -1, -1));

					//---- logoLabel ----
					logoLabel.setIcon(new ImageIcon(getClass().getResource("/static/img/logo-lg.png")));
					logoLabel.setText("");
					aboutPanel.add(logoLabel, new GridConstraints(0, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));

					//---- appNameLabel ----
					appNameLabel.setFont(new Font("Consolas", Font.BOLD, 36));
					appNameLabel.setText("Throwable-Kit");
					aboutPanel.add(appNameLabel, new GridConstraints(1, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));

					//---- versionLabel ----
					versionLabel.setFont(versionLabel.getFont().deriveFont(Font.BOLD, 18f));
					versionLabel.setText("version");
					aboutPanel.add(versionLabel, new GridConstraints(2, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));

					//---- powerByLabel ----
					powerByLabel.setFont(powerByLabel.getFont().deriveFont(18f));
					powerByLabel.setText("<html>Power by: <a href='http://throwable.club'>Throwable</a></html>");
					aboutPanel.add(powerByLabel, new GridConstraints(3, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));

					//---- forkLabel ----
					forkLabel.setFont(forkLabel.getFont().deriveFont(15f));
					forkLabel.setText("<html>Fork this <a href='https://github.com/zjcscut/throwable-kit'>kit</a> on github</html>");
					aboutPanel.add(forkLabel, new GridConstraints(5, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));

					//---- checkUpdateButton ----
					checkUpdateButton.setText("\u68c0\u67e5\u66f4\u65b0");
					aboutPanel.add(checkUpdateButton, new GridConstraints(4, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED,
						null, null, null));
				}
				tabbedPane.addTab("\u5173\u4e8e", aboutPanel);

				//======== helpPanel ========
				{
					helpPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

					//======== helpScrollPane ========
					{

						//---- helpTextPane ----
						helpTextPane.setMargin(new Insets(10, 30, 10, 10));
						helpScrollPane.setViewportView(helpTextPane);
					}
					helpPanel.add(helpScrollPane, new GridConstraints(0, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
						null, null, null));
				}
				tabbedPane.addTab("\u4f7f\u7528\u5e2e\u52a9", helpPanel);

				//======== jsonPanel ========
				{
					jsonPanel.setLayout(new GridLayoutManager(2, 2, new Insets(10, 10, 0, 0), -1, -1));
				}
				tabbedPane.addTab("JSON\u5de5\u5177", jsonPanel);

				//======== settingPanel ========
				{
					settingPanel.setPreferredSize(new Dimension(-1, -1));
					settingPanel.setLayout(new GridLayoutManager(1, 1, new Insets(10, 10, 10, 10), -1, -1));

					//======== settingScrollPane ========
					{

						//======== settingInnerPanel ========
						{
							settingInnerPanel.setMinimumSize(new Dimension(-1, -1));
							settingInnerPanel.setPreferredSize(new Dimension(-1, -1));
							settingInnerPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));

							//======== normalPanel ========
							{
								normalPanel.setBorder(new TitledBorder(new EtchedBorder(), "\u5e38\u89c4"));
								normalPanel.setLayout(new GridLayoutManager(2, 2, new Insets(15, 50, 10, 0), -1, -1));

								//---- autoCheckUpdateCheckBox ----
								autoCheckUpdateCheckBox.setText("\u542f\u52a8\u65f6\u81ea\u52a8\u68c0\u67e5\u66f4\u65b0");
								normalPanel.add(autoCheckUpdateCheckBox, new GridConstraints(0, 0, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
									GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));
								normalPanel.add(hSpacer2, new GridConstraints(0, 1, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									null, null, null));
								normalPanel.add(vSpacer2, new GridConstraints(1, 0, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									null, null, null));
							}
							settingInnerPanel.add(normalPanel, new GridConstraints(0, 0, 1, 1,
								GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								null, null, null));

							//======== facePanel ========
							{
								facePanel.setBorder(new TitledBorder(new EtchedBorder(), "\u5916\u89c2\u8bbe\u7f6e"));
								facePanel.setLayout(new GridLayoutManager(4, 3, new Insets(15, 50, 10, 0), -1, -1));
								facePanel.add(hSpacer3, new GridConstraints(0, 2, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									null, null, null));

								//---- settingThemeComboBox ----
								settingThemeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
									"Darcula",
									"\u7cfb\u7edf\u9ed8\u8ba4",
									"Windows",
									"Nimbus",
									"Metal",
									"Motif"
								}));
								facePanel.add(settingThemeComboBox, new GridConstraints(0, 1, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));

								//---- themeLabel ----
								themeLabel.setText("\u4e3b\u9898\u98ce\u683c");
								facePanel.add(themeLabel, new GridConstraints(0, 0, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
									GridConstraints.SIZEPOLICY_FIXED,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));
								facePanel.add(vSpacer3, new GridConstraints(3, 0, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									null, null, null));

								//---- fontLabel ----
								fontLabel.setText("\u5b57\u4f53");
								facePanel.add(fontLabel, new GridConstraints(1, 0, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
									GridConstraints.SIZEPOLICY_FIXED,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));

								//---- settingFontNameComboBox ----
								settingFontNameComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
									"Microsoft YaHei",
									"Microsoft YaHei Light",
									"Microsoft YaHei UI",
									"Microsoft YaHei UI Light"
								}));
								facePanel.add(settingFontNameComboBox, new GridConstraints(1, 1, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));

								//---- fontSizeLabel ----
								fontSizeLabel.setText("\u5b57\u53f7");
								facePanel.add(fontSizeLabel, new GridConstraints(2, 0, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
									GridConstraints.SIZEPOLICY_FIXED,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));

								//---- settingFontSizeComboBox ----
								settingFontSizeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
									"10",
									"11",
									"12",
									"13",
									"14",
									"15",
									"16",
									"17",
									"18",
									"19",
									"20",
									"21",
									"22",
									"23",
									"24",
									"25",
									"26"
								}));
								facePanel.add(settingFontSizeComboBox, new GridConstraints(2, 1, 1, 1,
									GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));
							}
							settingInnerPanel.add(facePanel, new GridConstraints(1, 0, 1, 1,
								GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								null, null, null));

							//======== updatePanel ========
							{
								updatePanel.setLayout(new GridLayoutManager(2, 2, new Insets(10, 20, 10, 0), -1, -1));

								//---- saveSettingButton ----
								saveSettingButton.setText("\u66f4\u65b0\u8bbe\u7f6e");
								updatePanel.add(saveSettingButton, new GridConstraints(0, 0, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									GridConstraints.SIZEPOLICY_FIXED,
									null, null, null));
								updatePanel.add(hSpacer4, new GridConstraints(0, 1, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									null, null, null));
								updatePanel.add(vSpacer4, new GridConstraints(1, 0, 1, 1,
									GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
									GridConstraints.SIZEPOLICY_CAN_SHRINK,
									GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
									null, null, null));
							}
							settingInnerPanel.add(updatePanel, new GridConstraints(2, 0, 1, 1,
								GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
								null, null, null));
						}
						settingScrollPane.setViewportView(settingInnerPanel);
					}
					settingPanel.add(settingScrollPane, new GridConstraints(0, 0, 1, 1,
						GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
						null, null, null));
				}
				tabbedPane.addTab("\u8bbe\u7f6e", settingPanel);
			}
			mainPanel.add(tabbedPane, new GridConstraints(0, 0, 1, 1,
				GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
				null, new Dimension(200, 200), null));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel mainPanel;
	private JTabbedPane tabbedPane;
	private JPanel aboutPanel;
	private JLabel logoLabel;
	private JLabel appNameLabel;
	private JLabel versionLabel;
	private JLabel powerByLabel;
	private JLabel forkLabel;
	private JButton checkUpdateButton;
	private JPanel helpPanel;
	private JScrollPane helpScrollPane;
	private JTextPane helpTextPane;
	private JPanel jsonPanel;
	private JPanel settingPanel;
	private JScrollPane settingScrollPane;
	private JPanel settingInnerPanel;
	private JPanel normalPanel;
	private JCheckBox autoCheckUpdateCheckBox;
	private JPanel facePanel;
	private JComboBox<String> settingThemeComboBox;
	private JLabel themeLabel;
	private JLabel fontLabel;
	private JComboBox<String> settingFontNameComboBox;
	private JLabel fontSizeLabel;
	private JComboBox<String> settingFontSizeComboBox;
	private JPanel updatePanel;
	private JButton saveSettingButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
