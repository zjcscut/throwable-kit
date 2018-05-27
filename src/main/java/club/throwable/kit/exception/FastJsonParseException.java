package club.throwable.kit.exception;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/19 12:43
 */
public class FastJsonParseException extends RuntimeException {

	public FastJsonParseException() {
		super();
	}

	public FastJsonParseException(String message) {
		super(message);
	}

	public FastJsonParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public FastJsonParseException(Throwable cause) {
		super(cause);
	}
}
