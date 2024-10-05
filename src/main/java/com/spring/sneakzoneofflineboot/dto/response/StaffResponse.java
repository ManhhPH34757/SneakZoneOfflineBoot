package com.spring.sneakzoneofflineboot.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffResponse {
    @Id
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
