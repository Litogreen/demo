package com.example.demo.exceptions;

import java.time.LocalDateTime;

public class ErrorDTO {

    private String path;
    private String message;
    private LocalDateTime timestamp;
    private String status;
    private String error;
    private String errorCode;
	public String getError() {
		return error;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}
	public String getPath() {
		return path;
	}
	public String getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setError(String error) {
		this.error = error;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
