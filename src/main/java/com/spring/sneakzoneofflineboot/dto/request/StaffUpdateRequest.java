package com.spring.sneakzoneofflineboot.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffUpdateRequest {
    String id;
    String staffCode;
    String fullName;
    String gender;
    LocalDate birthday;
    String phoneNumber;
    String address;
    String email;
    String username;
    String role;
    Instant createdAt;
    Instant updatedAt;
    Boolean isActive;
}
