package club.throwable.kit.support;

import club.throwable.kit.common.constant.JsonPanelConstant;
import club.throwable.kit.common.constant.TreeNodeType;
import club.throwable.kit.common.constant.UiConstant;
import club.throwable.kit.model.TreeNodePair;
import club.throwable.kit.support.listener.json.TreeNodeCopyKeyListener;
import club.throwable.kit.support.listener.json.TreeNodeCopyKeyValueListener;
import club.throwable.kit.support.listener.json.TreeNodeCopyValueListener;
import club.throwable.kit.support.listener.json.TreeNodeMenuListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.netbeans.swing.tabcontrol.DefaultTabDataModel;
import org.netbeans.swing.tabcontrol.TabData;
import org.netbeans.swing.tabcontrol.TabDataModel;
import org.netbeans.swing.tabcontrol.TabbedContainer;
import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 9:35
 */
public enum JsonPanelLayoutManager {

	/**
	 * singleton
	 */
	INSTANCE;

	private static ImageIcon ROOT_IMAGE_ICON;
	private static ImageIcon NODE_IMAGE_ICON;
	private static ImageIcon LEAF_IMAGE_ICON;

	static {
		ClassPathResource root = new ClassPathResource(UiConstant.TREE_ROOT_ICON_PATH);
		ClassPathResource node = new ClassPathResource(UiConstant.TREE_NODE_ICON_PATH);
		ClassPathResource leaf = new ClassPathResource(UiConstant.TREE_LEAF_ICON_PATH);
		try {
			ROOT_IMAGE_ICON = new ImageIcon(root.getURL());
			NODE_IMAGE_ICON = new ImageIcon(node.getURL());
			LEAF_IMAGE_ICON = new ImageIcon(leaf.getURL());
		}catch (Exception e){
			//ignore
		}
	}

	public TabbedContainer initializeJsonPanelTabbedContainer() {
		TabData first = createJsonPanelTabData("main", "main", null);
		TabDataModel tabDataModel = new DefaultTabDataModel(new TabData[]{first});
		TabbedContainer tabbedContainer = new TabbedContainer(tabDataModel, TabbedContainer.TYPE_EDITOR);
		tabbedContainer.getSelectionModel().setSelectedIndex(0);
		tabbedContainer.setShowCloseButton(Boolean.FALSE);
		return tabbedContainer;
	}

	public TabData createJsonPanelTabData(String name, String tip, Icon icon) {
		final JSplitPane splitPane = new JSplitPane();
		splitPane.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				splitPane.setDividerLocation(0.6);
			}

			@Override
			public void componentMoved(ComponentEvent e) {
			}

			@Override
			public void componentShown(ComponentEvent e) {
			}

			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		RSyntaxTextArea rSyntaxTextArea = RSyntaxTextAreaManager.INSTANCE.createRSyntaxTextArea();
		RTextScrollPane textScrollPane = new RTextScrollPane(rSyntaxTextArea);
		textScrollPane.setFoldIndicatorEnabled(Boolean.TRUE);
		textScrollPane.setIconRowHeaderEnabled(Boolean.TRUE);
		Gutter gutter = textScrollPane.getGutter();
		gutter.setBookmarkingEnabled(Boolean.TRUE);
		splitPane.setLeftComponent(textScrollPane);
		JTree jsonNodeTree = initializeJsonNodeTree();
		splitPane.setRightComponent(new JScrollPane(jsonNodeTree));
		return new TabData(splitPane, icon, name, tip);
	}

	private JTree initializeJsonNodeTree() {
		DefaultMutableTreeNode root = createTreeRootNode();
		DefaultTreeModel model = new DefaultTreeModel(root);
		JTree jsonNodeTree = new JTree(model);
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)jsonNodeTree.getCellRenderer();
		//叶子节点图标
		renderer.setLeafIcon(LEAF_IMAGE_ICON);
		//非叶子节点图标
		renderer.setIcon(ROOT_IMAGE_ICON);
		//关闭的节点的图标
		renderer.setClosedIcon(ROOT_IMAGE_ICON);
		//展开的节点的图标
		renderer.setOpenIcon(NODE_IMAGE_ICON);
		//禁用的节点的图标
		renderer.setDisabledIcon(NODE_IMAGE_ICON);
		BasicTreeUI treeUI = (BasicTreeUI) jsonNodeTree.getUI();
		//折叠时的图标
		treeUI.setCollapsedIcon(NODE_IMAGE_ICON);
		//展开时的图标
		treeUI.setExpandedIcon(NODE_IMAGE_ICON);
		createTreePopupMenu(jsonNodeTree);
		return jsonNodeTree;
	}

	public DefaultMutableTreeNode createTreeRootNode() {
		TreeNodePair rootNode = new TreeNodePair();
		rootNode.setType(TreeNodeType.ROOT);
		rootNode.setKey(JsonPanelConstant.ROOT);
		rootNode.setValue(JsonPanelConstant.ROOT);
		return new DefaultMutableTreeNode(rootNode);
	}

	private void createTreePopupMenu(JTree jsonNodeTree) {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem copyKey = new JMenuItem(JsonPanelConstant.MENU_ITEM_COPY_KEY);
		copyKey.addActionListener(new TreeNodeCopyKeyListener(jsonNodeTree));
		menu.add(copyKey);
		JMenuItem copyValue = new JMenuItem(JsonPanelConstant.MENU_ITEM_COPY_VALUE);
		copyValue.addActionListener(new TreeNodeCopyValueListener(jsonNodeTree));
		menu.add(copyValue);
		JMenuItem copyKeyValue = new JMenuItem(JsonPanelConstant.MENU_ITEM_COPY_KEY_VALUE);
		copyKeyValue.addActionListener(new TreeNodeCopyKeyValueListener(jsonNodeTree));
		menu.add(copyKeyValue);
		jsonNodeTree.addMouseListener(new TreeNodeMenuListener(jsonNodeTree, menu));
	}
}
