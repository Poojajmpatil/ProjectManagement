package com.cts.exception;

import org.springframework.beans.factory.annotation.Value;
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

@Value("${access_denied}")
private String access_denied;
@ExceptionHandler(value=AccessControlException.class)
public ResponseEntity<Object> accessException(AccessControlException exception)
{
	
	
	return new ResponseEntity<>(access_denied,HttpStatus.NOT_FOUND);
}


}