package br.com.uniportal.shared.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiReturn<T> {
    private boolean success;
    // TODO: implementar enum de erro.
    // private ErrorType errorType;
    private String errorType;
	private short errorCode;
	private String error;
    private String internalException;
    
    @JsonProperty("return")
    private T result;

    @Deprecated
    ApiReturn() {
    }

    ApiReturn(T result) {
        this.success = true;
        this.result = result;
    }

    ApiReturn(String errorMessage) {
        this.error = errorMessage;
    }

    ApiReturn(String errorType, String errorMessage) {
		this.errorType = errorType;
		this.error = errorMessage;
    }
    
	ApiReturn(String errorType, short errorCode, String errorMessage) {
        this.errorType = errorType;
        this.errorCode = errorCode;
		this.error = errorMessage;
	}

    ApiReturn(String errorType, short errorCode, String errorMessage, Throwable internalException) {
		this(errorType, errorCode, errorMessage);
		if (internalException != null) {
			this.internalException = internalException.getMessage();
        }
    }
    
    public static <T> ApiReturn<T> of(T t) {
        return new ApiReturn<T>(t);
    }

    public static ApiReturn<String> of(String errorType, short errorCode, String errorMessage, Throwable internalException) {
        return new ApiReturn<String>(errorType, errorCode, errorMessage, internalException);
    }
}