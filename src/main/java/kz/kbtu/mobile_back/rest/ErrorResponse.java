package kz.kbtu.mobile_back.rest;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class ErrorResponse implements Serializable {
    private String errorCode;
    private String errorMessage;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponse() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        if (isNotEmpty(errorMessage)) {
            return errorMessage + " (" + errorCode + ")";
        } else {
            return super.toString();
        }
    }
}
