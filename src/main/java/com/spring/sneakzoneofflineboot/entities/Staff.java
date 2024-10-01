package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staffs")
public class Staff {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "staff_code", nullable = false, length = 100)
     private String staffCode;

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
     @NotNull
     @Column(name = "username", nullable = false)
     private String username;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "password")
     private String password;

     @Size(max = 10)
     @NotNull
     @Column(name = "role", nullable = false, length = 10)
     private String role;

     @ColumnDefault("current_timestamp()")
     @Column(name = "created_at")
     private Instant createdAt;

     @ColumnDefault("current_timestamp()")
     @Column(name = "updated_at")
     private Instant updatedAt;

     @ColumnDefault("1")
     @Column(name = "is_active")
     private Boolean isActive;

}