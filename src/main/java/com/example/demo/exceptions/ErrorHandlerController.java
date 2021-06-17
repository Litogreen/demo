package com.example.demo.exceptions;

import static com.example.demo.exceptions.DemoResponseConst.ReturnCode.E9999;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ErrorHandlerController {
	private static final Logger LOGGER = LoggerFactory.getLogger( ErrorHandlerController.class );

	@ExceptionHandler(DemoException.class)
	public ResponseEntity<Object> handleDemoException(DemoException e) {
		LOGGER.info( "DemoException occurred, Error code : {}, Error message: {}",
				e.getReturnCode(),
				e.getMessage() );
		return returnErrorResponse( e.getReturnCode(), e.getExtInfo(), HttpStatus.BAD_REQUEST );
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		LOGGER.error( "Exception occurred, Error stack: ", e );
		return returnErrorResponse( E9999.name(), "", HttpStatus.INTERNAL_SERVER_ERROR );
	}

	private ResponseEntity<Object> returnErrorResponse(String errorCode, String msg,
			HttpStatus httpStatus) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus( String.valueOf( httpStatus.value() ) );
		errorDTO.setError( httpStatus.getReasonPhrase() );
		errorDTO.setMessage( msg );
		errorDTO.setTimestamp( LocalDateTime.now() );
		errorDTO.setErrorCode( errorCode );
		return ResponseEntity.status( httpStatus )
				.body( errorDTO );
	}
}
