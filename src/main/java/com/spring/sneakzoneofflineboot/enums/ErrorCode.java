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
     BRAND_NOT_EXISTED(404, "Brand not found", HttpStatus.NOT_FOUND),
     CATEGORY_NOT_EXISTED(404, "Category not found", HttpStatus.NOT_FOUND),
     MATERIAL_NOT_EXISTED(404, "Material not found", HttpStatus.NOT_FOUND),
     SOLE_NOT_EXISTED(404, "Sole not found", HttpStatus.NOT_FOUND),
     PRODUCT_NOT_EXISTED(404, "Product not found", HttpStatus.NOT_FOUND),
     COLOR_NOT_EXISTED(404, "Color not found", HttpStatus.NOT_FOUND),
     SIZE_NOT_EXISTED(404, "Size not found", HttpStatus.NOT_FOUND),
     ;

     Integer code;
     String message;
     HttpStatus statusCode;
}
