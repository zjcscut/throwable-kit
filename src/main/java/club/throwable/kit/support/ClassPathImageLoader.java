package club.throwable.kit.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:19
 */
@Slf4j
@Component
public class ClassPathImageLoader {

	private static final Map<String, Image> CACHE = new HashMap<>();

	public Image loadImage(String path) {
		if (CACHE.containsKey(path)) {
			return CACHE.get(path);
		} else {
			Image image = null;
			try {
				ClassPathResource resource = new ClassPathResource(path);
				if (resource.exists()) {
					image = Toolkit.getDefaultToolkit().getImage(resource.getURL());
					CACHE.put(path, image);
				}
			} catch (Exception e) {
				log.error("Load image for path:{} error", path, e);
			}
			return image;
		}
	}
}
