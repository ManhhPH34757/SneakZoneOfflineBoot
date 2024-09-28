package com.spring.sneakzoneofflineboot.services;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.spring.sneakzoneofflineboot.dto.request.AccountRequest;
import com.spring.sneakzoneofflineboot.dto.response.AccountResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.StaffRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {
     StaffRepository staffRepository;
     PasswordEncoder passwordEncoder;

     @NonFinal
     @Value("${jwt.secret-key}")
     String SECRET_KEY;

     public AccountResponse authenticated(AccountRequest request) {
          var staff = staffRepository.findByUsername(request.getUsername()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
          boolean authenticated = passwordEncoder.matches(request.getPassword(), staff.getPassword());
          if (!authenticated) {
               throw new AppException(ErrorCode.UNAUTHENTICATED);
          }
          var access_token = generateAccessToken(staff);
          return AccountResponse.builder()
               .accessToken(access_token)
               .authenticated(true)
               .build();
     }

     public String generateAccessToken(Staff staff) {
          JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

          Map<String, Object> userJson = new HashMap<>();
          userJson.put("id", staff.getId());
          userJson.put("email", staff.getEmail());
          userJson.put("fullname", staff.getFullName());

          JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
               .issuer("sneak-zone.store.com.vn")
               .issueTime(new Date())
               .expirationTime(new Date(Instant.now().plus(12, ChronoUnit.HOURS).toEpochMilli()))
               .claim("user", userJson)
               .claim("scope", staff.getRole())
               .build();

          Payload payload = new Payload(claimsSet.toJSONObject());
          JWSObject jwsObject= new JWSObject(header, payload);

          try {
               jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
               return jwsObject.serialize();
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }
}
