package club.throwable.kit.utils;

import club.throwable.kit.exception.FastJsonParseException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/12/10 12:36
 */
public enum FastjsonUtils {

	INSTANCE;

	private static final Feature[] PARSE_FEATURE = {Feature.AllowSingleQuotes};
	private static final SerializerFeature[] SERIALIZER_FEATURE = {SerializerFeature.WriteMapNullValue,
			SerializerFeature.PrettyFormat};

	public String parseAndFormatJson(String text) {
		return format(parse(text));
	}

	public Object parse(String text) {
		try {
			return JSON.parse(text, PARSE_FEATURE);
		} catch (Exception e) {
			throw new FastJsonParseException(e);
		}
	}

	public String format(Object target) {
		try {
			return JSON.toJSONString(target, SERIALIZER_FEATURE);
		} catch (Exception e) {
			throw new FastJsonParseException(e);
		}
	}

	public String minify(String jsonText) {
		try {
			Object target = JSON.parse(jsonText, PARSE_FEATURE);
			return JSON.toJSONString(target);
		} catch (Exception e) {
			throw new FastJsonParseException(e);
		}
	}
}
