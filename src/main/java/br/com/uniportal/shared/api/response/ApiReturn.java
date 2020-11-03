package br.com.uniportal.shared.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiReturn<T> {
	private boolean success;
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


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(final T result) {
        this.result = result;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getInternalException() {
        return internalException;
    }

    public void setInternalException(String internalException) {
        this.internalException = internalException;
    }

    public short getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(short errorCode) {
        this.errorCode = errorCode;
    }


    /**
	 * Se a chamada retornou OK então retorna o resultado da API senão lança uma
	 * exception com o erro da API.
	 * 
	 * @return retorno API
	 * @throws ApiReturnException erro da API
	 */
	// @JsonIgnore
	// public T getResultOrError() {
	// 	// if (success)
    //         return result;
        
	// 	// throw CiaAtitudeException.of(ErrorType.getErrorTypeForCode(errorCode), errorCode, error);
	// }
    
    public static <T> ApiReturn<T> of(T t) {
        return new ApiReturn<T>(t);
    }
    
    public static ApiReturn<String> of(String errorType, short errorCode, String errorMessage, Throwable internalException) {
        return new ApiReturn<String>(errorType, errorCode, errorMessage, internalException);
    }

    // public static ApiReturn<String> ofException(String errorMessage, Throwable internalException) {
	// 	return of(ErrorType.Exception, ErrorType.Exception.getCode(), errorMessage, internalException);
    // }
    
    // public static ApiReturn<String> ofCiaAtitude(CiaAtitudeException ex) {
	// 	return of(ex.getErrorType(), ex.getErrorCode(), ex.getMessage(), ex);
    // }
}