package com.appsstuff.pattern.proxy.apis;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvisor{

    @ExceptionHandler({ BookNotFoundException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public  @ResponseBody ResponseException bookNotFound(final BookNotFoundException e) {
		ResponseException response = new ResponseException();
		response.setMessage("Book Not Found");
		response.setException(e.getMessage());
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		response.setMsgDate(new Date());
		return response;
		
	}
	}
