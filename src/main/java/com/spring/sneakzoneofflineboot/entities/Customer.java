package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "customer_code", nullable = false, length = 100)
     private String customerCode;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "full_name")
     private String fullName;

     @Size(max = 10)
     @ColumnDefault("''")
     @Column(name = "gender", length = 10)
     private String gender;

     @ColumnDefault("curdate()")
     @Column(name = "birthday")
     private LocalDate birthday;

     @Size(max = 13)
     @NotNull
     @Column(name = "phone_number", nullable = false, length = 13)
     private String phoneNumber;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "address")
     private String address;

     @Size(max = 255)
     @NotNull
     @Column(name = "email", nullable = false)
     private String email;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "password")
     private String password;

     @ColumnDefault("0.00000")
     @Column(name = "accumulated_points", precision = 65, scale = 5)
     private BigDecimal accumulatedPoints;

     @ColumnDefault("current_timestamp()")
     @Column(name = "created_at")
     private Instant createdAt;

     @ColumnDefault("current_timestamp()")
     @Column(name = "updated_at")
     private Instant updatedAt;

}