package club.throwable.kit.support;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;

import java.awt.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 9:36
 */
public enum RSyntaxTextAreaManager {

	/**
	 * singleton
	 */
	INSTANCE;

	public RSyntaxTextArea createRSyntaxTextArea() {
		RSyntaxTextArea textArea = new RSyntaxTextArea();
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
		textArea.setCodeFoldingEnabled(Boolean.TRUE);
		textArea.setAntiAliasingEnabled(Boolean.TRUE);
		textArea.setAutoscrolls(Boolean.TRUE);
		textArea.setMarkOccurrences(Boolean.TRUE);
		//前面空出两个tab
		textArea.setTabSize(2);
		textArea.setAnimateBracketMatching(Boolean.TRUE);
		textArea.setPaintTabLines(Boolean.TRUE);
		//光标颜色
		textArea.setCaretColor(Color.RED);
		//背景色 - 背景色和目前的设置不相容，暂时不设置
//		textArea.setBackground(new ColorUIResource(3948353));
		SyntaxScheme scheme = textArea.getSyntaxScheme();
		scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = Color.BLUE;
		scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = new Color(164, 0, 0);
		scheme.getStyle(Token.LITERAL_NUMBER_FLOAT).foreground = new Color(164, 0, 0);
		scheme.getStyle(Token.LITERAL_BOOLEAN).foreground = Color.RED;
		scheme.getStyle(Token.OPERATOR).foreground = Color.BLACK;
		textArea.revalidate();
		setFont(textArea, new Font("Default", Font.PLAIN, 15));
		return textArea;
	}

	public void setFont(RSyntaxTextArea textArea, Font font) {
		if (font != null) {
			SyntaxScheme ss = textArea.getSyntaxScheme();
			ss = (SyntaxScheme) ss.clone();
			for (int i = 0; i < ss.getStyleCount(); i++) {
				if (ss.getStyle(i) != null) {
					ss.getStyle(i).font = font;
				}
			}
			textArea.setSyntaxScheme(ss);
			textArea.setFont(font);
		}
	}
}
