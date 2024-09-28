package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.request.AccountRequest;
import com.spring.sneakzoneofflineboot.dto.response.AccountResponse;
import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

     AuthService authService;

     @PostMapping("/token")
     public ApiResponse<AccountResponse> generateToken(@RequestBody AccountRequest authRequest) {
          return ApiResponse.<AccountResponse>builder()
               .result(authService.authenticated(authRequest))
               .build();
     }
}
