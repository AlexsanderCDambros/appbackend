package com.alcd.appbackend.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alcd.appbackend.services.exceptions.BadRequestException;
import com.alcd.appbackend.services.exceptions.ObjectNotFoundException;
import com.alcd.appbackend.services.exceptions.UnickKeyException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(
			ObjectNotFoundException e, 
			HttpServletRequest request
	) {
		StandardError err = new StandardError(
				HttpStatus.NOT_FOUND.value(), 
				e.getMessage(), 
				System.currentTimeMillis()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(UnickKeyException.class)
	public ResponseEntity<StandardError> objectNotFound(
			UnickKeyException e, 
			HttpServletRequest request
	) {
		StandardError err = new StandardError(
				HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				e.getMessage(), 
				System.currentTimeMillis()
		);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> objectNotFound(
			BadRequestException e, 
			HttpServletRequest request
	) {
		StandardError err = new StandardError(
				HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				e.getMessage(), 
				System.currentTimeMillis()
		);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
}
