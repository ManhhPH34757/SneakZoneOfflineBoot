package com.spring.sneakzoneofflineboot.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CustomerResponse {
    @Id
    String id;

    String customerCode;

    String fullName;

    String gender;

    LocalDate birthday;

    String phoneNumber;

    String address;

    String email;

    BigDecimal accumulatedPoints;

    Instant createdAt;

    Instant updatedAt;
}
