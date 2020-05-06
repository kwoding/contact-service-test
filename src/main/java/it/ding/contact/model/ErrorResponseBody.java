package it.ding.contact.model;

import java.util.Date;
import java.util.Map;

public class ErrorResponseBody {

    private Date timestamp;

    private Integer status;

    private String error;

    private Map<String, String> fieldErrors;

    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponseBody withTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ErrorResponseBody withStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ErrorResponseBody withError(String error) {
        this.error = error;
        return this;
    }

    public ErrorResponseBody withFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }

    public ErrorResponseBody withMessage(String message) {
        this.message = message;
        return this;
    }

}
