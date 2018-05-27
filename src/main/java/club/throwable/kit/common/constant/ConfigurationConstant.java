package club.throwable.kit.common.constant;

import java.io.File;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:13
 */
public class ConfigurationConstant {

	public static final String MAC_OS = "Mac";

	public static final String OS_NAME = System.getProperty("os.name");

	private static final String CONFIGURATION_APPLICATION_NAME = ".ThrowableKit";

	public static final String CONFIGURATION_FILE = "configuration.json";

	public static final String CONFIGURATION_DIR = String.format("%s%s%s%s", System.getProperty("user.home"),
			File.separator, CONFIGURATION_APPLICATION_NAME, File.separator);

	public static final int LOADING_SLEEP_MILLION_SECONDS = 3000;
}
