package com.spring.sneakzoneofflineboot.configs;

import com.spring.sneakzoneofflineboot.entities.Staff;
import com.spring.sneakzoneofflineboot.repositories.StaffRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {

     PasswordEncoder passwordEncoder;

     @Bean
     public ApplicationRunner applicationRunner(StaffRepository staffRepository) {
          return args -> {
               if (staffRepository.findByUsername("admin").isEmpty()) {
                    UUID uuid = UUID.randomUUID();
                    Staff staff = Staff.builder().id(uuid.toString())
                         .staffCode("ST2024183001")
                         .fullName("Admin")
                         .gender("Male")
                         .birthday(LocalDate.of(2004, 7, 27))
                         .phoneNumber("0387172021")
                         .address("Hanoi")
                         .email("admin@example.com")
                         .username("admin")
                         .password(passwordEncoder.encode("123456"))
                         .role("ADMIN")
                         .createdAt(Instant.now())
                         .updatedAt(Instant.now())
                         .isActive(true)
                         .build();
                    staffRepository.save(staff);
                    log.info("Admin created! Password default: 123456, please change it!");
               }
          };
     }

}
