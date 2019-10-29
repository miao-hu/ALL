public class NotExistPersonException extends Exception{
    public NotExistPersonException() {
        super();
    }

    public NotExistPersonException(String message) {
        super(message);
    }

    public NotExistPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistPersonException(Throwable cause) {
        super(cause);
    }

    protected NotExistPersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
