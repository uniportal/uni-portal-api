package br.com.uniportal.shared.api.error;


public class UniPortalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	protected String errorType;
    protected short errorCode;

    protected UniPortalException(String error) {
        super(error);
        this.errorType = errorType;
    }

    protected UniPortalException(String errorType, short errorCode, String error) {
        super(error);
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    protected UniPortalException(String errorType, short errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
		this.errorCode = errorCode;
    }

    public static UniPortalException ofValidation(String message) {
		return new UniPortalException(message);
    }

    public short getErrorCode() {
        return errorCode;
    }
    public String getErrorType() {
        return errorType;
    }
}