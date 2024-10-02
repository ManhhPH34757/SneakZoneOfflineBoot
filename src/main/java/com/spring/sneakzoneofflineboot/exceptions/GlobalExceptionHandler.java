package com.spring.sneakzoneofflineboot.exceptions;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(value = Exception.class)
     public ResponseEntity<ApiResponse<AppException>> handlingRuntimeException(RuntimeException exception) {
          ApiResponse<AppException> apiResponse = new ApiResponse<>();
          apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
          apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
          return ResponseEntity.badRequest().body(apiResponse);
     }

     @ExceptionHandler(value = AppException.class)
     public ResponseEntity<ApiResponse<AppException>> handlingAppException(AppException exception) {
          ErrorCode errorCode = exception.getErrorCode();
          ApiResponse<AppException> apiResponse = new ApiResponse<>();
          apiResponse.setCode(errorCode.getCode());
          apiResponse.setMessage(errorCode.getMessage());
          return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
     }

     @ExceptionHandler(value = AccessDeniedException.class)
     public ResponseEntity<ApiResponse<AppException>> handlingAccessDeniedException(AccessDeniedException exception) {
          ErrorCode errorCode = ErrorCode.UNAUTHORIZED;
          ApiResponse<AppException> apiResponse = new ApiResponse<>();
          apiResponse.setMessage(errorCode.getMessage());
          return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
     }

     @ExceptionHandler(value = MethodArgumentNotValidException.class)
     public ResponseEntity<ApiResponse<AppException>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
          String enumKey = Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();
          ErrorCode errorCode = ErrorCode.INVALID_KEY;
          try {
               errorCode = ErrorCode.valueOf(enumKey);
          } catch (IllegalArgumentException e) {
               throw new RuntimeException(e);
          }

          ApiResponse<AppException> apiResponse = new ApiResponse<>();
          apiResponse.setCode(errorCode.getCode());
          apiResponse.setMessage(errorCode.getMessage());

          return ResponseEntity.badRequest().body(apiResponse);
     }
}
