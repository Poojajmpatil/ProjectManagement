package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class StoryExceptionController {
	
	@org.springframework.beans.factory.annotation.Value("${story_not_found}")

	private String storyNotFound;

@ExceptionHandler(value= StoryNotFoundException.class)
	public ResponseEntity<Object> exception(StoryNotFoundException exception)
	{
		return new ResponseEntity<>(storyNotFound,HttpStatus.NOT_FOUND);
	}

}