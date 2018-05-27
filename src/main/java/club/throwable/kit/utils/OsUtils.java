package club.throwable.kit.utils;


import static club.throwable.kit.common.constant.ConfigurationConstant.MAC_OS;
import static club.throwable.kit.common.constant.ConfigurationConstant.OS_NAME;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:12
 */
public enum OsUtils {

	/**
	 * singleton
	 */
	INSTANCE;

	public boolean isMacOs() {
		return OS_NAME.equalsIgnoreCase(MAC_OS);
	}
}
