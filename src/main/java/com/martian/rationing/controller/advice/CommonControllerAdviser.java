package com.martian.rationing.controller.advice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.martian.rationing.dto.ResponseDTO;
import com.martian.rationing.enums.StatusEnum;
import com.martian.rationing.exceptions.BadRequestException;

@RestController
@ControllerAdvice
public class CommonControllerAdviser {

	private static final Logger LOGGER = Logger.getLogger(CommonControllerAdviser.class.getName());

	@ExceptionHandler(BadRequestException.class)
	public ResponseDTO<?> handleBadRequestException(BadRequestException badRequestException) {
		return prepareResponseVO(badRequestException.getErrorCode(), badRequestException.getErrorMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseDTO<?> handleUnknownException(Exception exception) {
		logger(exception);
		return prepareResponseVO(StatusEnum.UNKNOWN_EXCEPTION.getStatusCode(), exception.getMessage());
	}

	private ResponseDTO<?> prepareResponseVO(String errorCode, String errorMessage) {
		return new ResponseDTO<>(errorCode, errorMessage);
	}

	private void logger(Throwable throwable) {
		LOGGER.log(Level.SEVERE, null, throwable);
	}
}
