package club.throwable.kit.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:56
 */
@Data
@ToString
public class GlobalSettingProperty {

	private Boolean autoCheckUpdate;
	private String font;
	private Integer fontSize;
	private String theme;
	private Boolean lowDpiScreen;
	private Boolean highDpiScreen;
}
