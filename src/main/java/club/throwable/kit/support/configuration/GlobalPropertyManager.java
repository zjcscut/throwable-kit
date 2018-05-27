package club.throwable.kit.support.configuration;

import club.throwable.kit.common.constant.ConfigurationConstant;
import club.throwable.kit.common.constant.DefaultSettingConstant;
import club.throwable.kit.model.GlobalSettingProperty;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/18 23:53
 */
@Slf4j
@Component
public class GlobalPropertyManager implements InitializingBean {

	private GlobalSettingProperty globalSettingProperty;
	private File configurationFile;

	@Override
	public void afterPropertiesSet() throws Exception {
		initializeConfiguration();
	}

	private void initializeConfiguration() throws Exception {
		File configurationDir = new File(ConfigurationConstant.CONFIGURATION_DIR);
		//不存在配置目录则创建
		if (!configurationDir.exists()) {
			boolean result = configurationDir.mkdirs();
			log.debug("Create configuration dir " + (result ? "success" : "failed"));
		}
		configurationFile = new File(String.format("%s%s", ConfigurationConstant.CONFIGURATION_DIR,
				ConfigurationConstant.CONFIGURATION_FILE));
		if (configurationFile.exists()) {
			String content = FileCopyUtils.copyToString(new FileReader(configurationFile));
			if (StringUtils.hasLength(content)) {
				globalSettingProperty = JSON.parseObject(content, GlobalSettingProperty.class);
			}
		} else {
			boolean result = configurationFile.createNewFile();
			log.debug("Create configuration file " + (result ? "success" : "failed"));
			globalSettingProperty = initializeDefaultGlobalSettingProperty();
			saveGlobalSettingProperty(globalSettingProperty);
		}
	}

	private GlobalSettingProperty initializeDefaultGlobalSettingProperty() {
		GlobalSettingProperty globalSettingProperty = new GlobalSettingProperty();
		globalSettingProperty.setFont(DefaultSettingConstant.FONT);
		globalSettingProperty.setFontSize(DefaultSettingConstant.FONT_SIZE);
		globalSettingProperty.setTheme(DefaultSettingConstant.THEME);
		globalSettingProperty.setAutoCheckUpdate(DefaultSettingConstant.AUTO_CHECK_UPDATE);
		return globalSettingProperty;
	}

	public void saveGlobalSettingProperty(GlobalSettingProperty globalSettingProperty) {
		try {
			FileWriter fileWriter = new FileWriter(configurationFile);
			fileWriter.write(JSON.toJSONString(globalSettingProperty, Boolean.TRUE));
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			log.error("Save configuration file error,property:{}", globalSettingProperty, e);
		}
	}

	public GlobalSettingProperty getGlobalSettingProperty() {
		return globalSettingProperty;
	}

	public String getTheme() {
		return globalSettingProperty.getTheme();
	}
}
