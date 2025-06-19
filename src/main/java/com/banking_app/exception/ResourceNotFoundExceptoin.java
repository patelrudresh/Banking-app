package com.banking_app.exception;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptoin extends RuntimeException {
	
	public ResourceNotFoundExceptoin(String message) {
		super(message);
	}

}
