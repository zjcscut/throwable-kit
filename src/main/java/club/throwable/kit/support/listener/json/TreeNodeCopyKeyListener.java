package club.throwable.kit.support.listener.json;


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
public class TreeNodeCopyKeyListener implements ActionListener {

	private final JTree delegate;

	public TreeNodeCopyKeyListener(JTree delegate) {
		this.delegate = delegate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) delegate.getSelectionPath().getLastPathComponent();
		if (null != node) {
			TreeNodePair pair = (TreeNodePair) node.getUserObject();
			if (null != pair) {
				ClipboardUtils.INSTANCE.resetClipboardContent(pair.getKey());
			}
		}
	}
}
