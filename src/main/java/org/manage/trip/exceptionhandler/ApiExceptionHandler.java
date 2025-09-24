package org.manage.trip.exceptionhandler;

import org.manage.trip.exception.TripDataNotFound;
import org.manage.trip.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(TripDataNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleTripDataNotFoundException(TripDataNotFound tripDataNotFound) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .message(tripDataNotFound.getMessage())
                .timeStamp(LocalDateTime.now().toString())
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .message(exception.getMessage())
                .timeStamp(LocalDateTime.now().toString())
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
