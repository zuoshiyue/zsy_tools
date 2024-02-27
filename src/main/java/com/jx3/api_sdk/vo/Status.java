package com.jx3.api_sdk.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.jx3.api_sdk.exception.StatusCodeException;
import com.jx3.api_sdk.util.JsonUtil;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 状态码
 */
public class Status implements Serializable, Comparable<Status> {

    private static final long serialVersionUID = -3612327781251162486L;

    public static final int ERROR = -2020;

    public static final int SUCCESS = 0;

    private final int code;

    private final String msg;

    @JsonCreator
    protected Status(@JsonProperty("code") int code, @JsonProperty("msg") String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Status create(int status, String reason) {
        return new Status(status, reason);
    }

    public static Status success() {
        return create(SUCCESS, null);
    }

    public static Status error(String reason) {
        return create(ERROR, reason);
    }

    public static Status error(int status, String reason) {
        Preconditions.checkArgument(status < SUCCESS, "code must be less than 0");
        return create(status, reason);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code >= SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public StatusCodeException asError() {
        return new StatusCodeException(this);
    }

    public StatusCodeException asError(String message) {
        return new StatusCodeException(message, this);
    }

    public StatusCodeException asError(String message, Throwable cause) {
        return new StatusCodeException(message, cause, this);
    }

    public StatusCodeException asError(Throwable cause) {
        return new StatusCodeException(cause, this);
    }

    @Override
    public int compareTo(Status o) {
        return code - o.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Status)) {
            return false;
        }

        Status status1 = (Status) o;

        if (code != status1.code) {
            return false;
        }
        return Objects.equals(msg, status1.msg);
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", code);
        map.put("msg", msg);
        return JsonUtil.toJson(map);
    }
}
