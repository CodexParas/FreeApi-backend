package com.paras.FreeAPIs.handler;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleException (ResourceNotFoundException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ResponseDTO.error("Resource not found", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException (Exception e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ResponseDTO.error("Internal server error", e.getMessage()));
    }
}