package com.jx3.api_sdk.exception;

/**
 * JSON异常
 */
public class JsonException extends RuntimeException {

    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
