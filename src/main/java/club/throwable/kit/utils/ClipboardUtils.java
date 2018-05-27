package club.throwable.kit.utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author throwable
 * @version v1.0
 * @description 剪贴板工具
 * @since 2018/5/18 21:48
 */
public enum ClipboardUtils {

	/**
	 * singleton
	 */
	INSTANCE;

	public void resetClipboardContent(String content) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transferable = new StringSelection(content);
		clipboard.setContents(transferable, null);
	}
}
