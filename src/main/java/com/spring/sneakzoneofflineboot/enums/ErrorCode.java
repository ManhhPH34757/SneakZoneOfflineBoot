package com.spring.sneakzoneofflineboot.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
     UNCATEGORIZED_EXCEPTION(500, "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
     UNAUTHORIZED(401, "Unauthorized access", HttpStatus.UNAUTHORIZED),
     UNAUTHENTICATED(403, "Authentication required", HttpStatus.FORBIDDEN),
     USER_EXISTED(400, "User already exists", HttpStatus.BAD_REQUEST),
     USER_NOT_EXISTED(404, "User not found", HttpStatus.NOT_FOUND),
     INVALID_KEY(402, "Invalid key", HttpStatus.BAD_REQUEST),
     ;

     Integer code;
     String message;
     HttpStatus statusCode;
}
