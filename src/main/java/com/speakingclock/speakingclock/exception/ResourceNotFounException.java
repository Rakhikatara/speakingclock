package com.speakingclock.speakingclock.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFounException extends RuntimeException {
	
	public ResourceNotFounException(String message) {
		super(message);
	}

}