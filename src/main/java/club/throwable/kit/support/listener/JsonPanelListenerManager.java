package club.throwable.kit.support.listener;

import club.throwable.kit.support.IconImageProcessor;
import club.throwable.kit.support.PreferredSizeProcessor;
import club.throwable.kit.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 12:27
 */
@Component
public class JsonPanelListenerManager {

	@Autowired
	private IconImageProcessor iconImageProcessor;

	@Autowired
	private PreferredSizeProcessor preferredSizeProcessor;

	public void addOpenJsonParserButtonListener(MainWindow mainWindow){
//		mainWindow.getOpenJsonParserButton().addActionListener(event->{
//			JsonParserFrame jsonParserFrame = new JsonParserFrame();
//			//适配Mac的Dock
//			iconImageProcessor.applyIconImageIfNecessary(jsonParserFrame);
//			//适配屏幕大小
//			preferredSizeProcessor.applyPreferredSize(jsonParserFrame);
//			jsonParserFrame.getJFrame().setVisible(Boolean.TRUE);
//		});
	}
}
