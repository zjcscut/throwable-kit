package club.throwable.kit.support.listener.json;


import club.throwable.kit.common.constant.TreeNodeType;
import club.throwable.kit.model.TreeNodePair;
import club.throwable.kit.utils.ClipboardUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/12/13 22:25
 */
public class TreeNodeCopyValueListener implements ActionListener {

	private final JTree delegate;

	public TreeNodeCopyValueListener(JTree delegate) {
		this.delegate = delegate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) delegate.getSelectionPath().getLastPathComponent();
		if (null != node) {
			TreeNodePair pair = (TreeNodePair) node.getUserObject();
			if (null != pair && TreeNodeType.LEAF.equals(pair.getType())) {
				ClipboardUtils.INSTANCE.resetClipboardContent(String.valueOf(pair.getValue()));
			}
		}
	}
}
