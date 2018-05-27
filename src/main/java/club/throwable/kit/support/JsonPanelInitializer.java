package club.throwable.kit.support;

import club.throwable.kit.ui.MainWindow;
import club.throwable.kit.utils.FastjsonUtils;
import com.intellij.uiDesigner.core.GridConstraints;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.netbeans.swing.tabcontrol.TabData;
import org.netbeans.swing.tabcontrol.TabDataModel;
import org.netbeans.swing.tabcontrol.TabbedContainer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/26 22:36
 */
@Component
public class JsonPanelInitializer {

	private TabbedContainer tabbedContainer;
	private TabDataModel tabDataModel;
	private JPanel jsonPanel;
	private static final AtomicLong COUNTER = new AtomicLong(0);

	public void initializeJsonPanel(MainWindow mainWindow) {
		jsonPanel = mainWindow.getJsonPanel();
		TabbedContainer tabbedContainer = JsonPanelLayoutManager.INSTANCE.initializeJsonPanelTabbedContainer();
		RSyntaxTextArea rSyntaxTextArea = JsonParserComponentSelector.INSTANCE.getRSyntaxTextArea(tabbedContainer);
		createListenersForTextArea(rSyntaxTextArea);
		this.tabbedContainer = tabbedContainer;
		this.tabDataModel = tabbedContainer.getModel();
		GridConstraints constraints = new GridConstraints();
		constraints.setFill(GridConstraints.FILL_BOTH);
		jsonPanel.add(tabbedContainer, constraints);
	}

	private List<JMenuItem> createOptionMenu() {
		List<JMenuItem> menu = new ArrayList<>(4);
		JMenuItem addTab = createMenuItem("新建Tab", KeyEvent.VK_N);
		addTab.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewTab("tab-" + COUNTER.getAndIncrement(), Boolean.TRUE);
			}
		});
		menu.add(addTab);
		JMenuItem format = createMenuItem("格式化json", KeyEvent.VK_F);
		format.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent event) {
				formatJson();
			}
		});
		menu.add(format);
		JMenuItem minify = createMenuItem("最小化json", KeyEvent.VK_M);
		minify.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				minifyJson();
			}
		});
		menu.add(minify);
		JMenuItem deleteTab = createMenuItem("删除tab", KeyEvent.VK_R);
		deleteTab.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteTab();
			}
		});
		menu.add(deleteTab);
		return menu;
	}

	private void formatJson() {
		RSyntaxTextArea textArea = JsonParserComponentSelector.INSTANCE.getRSyntaxTextArea(tabbedContainer);
		String text = textArea.getText();
		if (StringUtils.hasLength(text)) {
			char c = text.trim().charAt(0);
			if (c == '{' || c == '[') {
				try {
					Object target = FastjsonUtils.INSTANCE.parse(text);
					String json = FastjsonUtils.INSTANCE.format(target);
					populateRSyntaxTextArea(json, textArea);
					populateTree(target);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(jsonPanel, e.getMessage(), "格式化json失败",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void minifyJson() {
		RSyntaxTextArea textArea = JsonParserComponentSelector.INSTANCE.getRSyntaxTextArea(tabbedContainer);
		String text = textArea.getText();
		if (StringUtils.hasLength(text)) {
			char c = text.trim().charAt(0);
			if (c == '{' || c == '[') {
				try {
					String json = FastjsonUtils.INSTANCE.minify(text);
					populateRSyntaxTextArea(json, textArea);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(jsonPanel, e.getMessage(), "最小化json失败",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void populateRSyntaxTextArea(String json, RSyntaxTextArea textArea) {
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
		textArea.setText(json);
	}


	private JMenuItem createMenuItem(String name, int keyCode) {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setAccelerator(KeyStroke.getKeyStroke(keyCode, InputEvent.CTRL_MASK));
		menuItem.setText(name);
		return menuItem;
	}

	private void deleteTab() {
		int selectedIndex = tabbedContainer.getSelectionModel().getSelectedIndex();
		int count = tabbedContainer.getTabCount();
		//第一个tab不能删除
		if (0 != selectedIndex && count > 0) {
			TabDataModel model = tabbedContainer.getModel();
			model.removeTab(selectedIndex);
		}
	}

	private int addNewTab(String name, boolean selected) {
		TabData tabData = JsonPanelLayoutManager.INSTANCE.createJsonPanelTabData(name, name, null);
		int index = tabbedContainer.getTabCount();
		tabDataModel.addTab(index, tabData);
		if (selected) {
			tabbedContainer.getSelectionModel().setSelectedIndex(index);
		}
		RSyntaxTextArea rSyntaxTextArea = JsonParserComponentSelector.INSTANCE.getRSyntaxTextArea(tabbedContainer);
		createListenersForTextArea(rSyntaxTextArea);
		return index;
	}

	private JTree populateTree(Object jsonObject) {
		JTree jTree = JsonParserComponentSelector.INSTANCE.getTree(tabbedContainer);
		DefaultMutableTreeNode root = JsonPanelLayoutManager.INSTANCE.createTreeRootNode();
		DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
		//填充树表数据
		JsonTreeViewParser.INSTANCE.parseJsonTree(jsonObject, root);
		jTree.setVisible(Boolean.TRUE);
		model.setRoot(root);
		//填充树表图标
		return jTree;
	}

	private void createListenersForTextArea(RSyntaxTextArea rSyntaxTextArea) {
		for (JMenuItem menuItem : createOptionMenu()) {
			rSyntaxTextArea.getPopupMenu().add(menuItem);
		}
		rSyntaxTextArea.addKeyListener((new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				//组合键 control + X
				if (keyEvent.isControlDown()) {
					if (keyEvent.getKeyCode() == KeyEvent.VK_R) {
						deleteTab();
					} else if (keyEvent.getKeyCode() == KeyEvent.VK_N) {
						addNewTab("tab-" + COUNTER.getAndIncrement(), Boolean.TRUE);
					} else if (keyEvent.getKeyCode() == KeyEvent.VK_F) {
						formatJson();
					} else if (keyEvent.getKeyCode() == KeyEvent.VK_M) {
						minifyJson();
					}
				}
			}
		}));
	}

	public TabbedContainer getTabbedContainer() {
		return tabbedContainer;
	}

	public TabDataModel getTabDataModel() {
		return tabDataModel;
	}
}
