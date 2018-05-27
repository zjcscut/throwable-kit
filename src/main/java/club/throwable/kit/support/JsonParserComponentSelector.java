package club.throwable.kit.support;

import club.throwable.kit.utils.AssertUtils;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.netbeans.swing.tabcontrol.TabData;
import org.netbeans.swing.tabcontrol.TabDataModel;
import org.netbeans.swing.tabcontrol.TabbedContainer;

import javax.swing.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 12:44
 */
public enum JsonParserComponentSelector {

	INSTANCE;

	public int getSelectedTabIndex(TabbedContainer tabbedContainer) {
		return tabbedContainer.getSelectionModel().getSelectedIndex();
	}

	public RSyntaxTextArea getRSyntaxTextArea(TabbedContainer tabbedContainer) {
		int index = getSelectedTabIndex(tabbedContainer);
		TabDataModel model = tabbedContainer.getModel();
		AssertUtils.INSTANCE.assertTrue(index >= 0, "Fetch textArea error!");
		AssertUtils.INSTANCE.assertNotNull(model, "Fetch tabDataModel error!");
		TabData tabData = model.getTab(index);
		JSplitPane jSplitPane = (JSplitPane) tabData.getComponent();
		JScrollPane jScrollPane = (JScrollPane) jSplitPane.getLeftComponent();
		JViewport jViewport = (JViewport) jScrollPane.getComponent(0);
		return (RSyntaxTextArea) jViewport.getComponent(0);
	}

	public JTree getTree(TabbedContainer tabbedContainer) {
		int index = getSelectedTabIndex(tabbedContainer);
		TabDataModel model = tabbedContainer.getModel();
		AssertUtils.INSTANCE.assertTrue(index >= 0, "Fetch textArea error!");
		AssertUtils.INSTANCE.assertNotNull(model, "Fetch tabDataModel error!");
		TabData tabData = model.getTab(index);
		JSplitPane jSplitPane = (JSplitPane) tabData.getComponent();
		JScrollPane jScrollPane = (JScrollPane) jSplitPane.getRightComponent();
		JViewport jViewport = (JViewport) jScrollPane.getComponent(0);
		return (JTree) jViewport.getComponent(0);
	}
}
