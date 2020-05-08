package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionController {

	@org.springframework.beans.factory.annotation.Value("${user_not_found}")

	private String userNotFound;

@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception)
	{
		return new ResponseEntity<>(userNotFound,HttpStatus.NOT_FOUND);
	}

}