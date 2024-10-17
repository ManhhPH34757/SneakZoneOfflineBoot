package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {

    Optional<Staff> findByUsernameAndIsActive(String username, boolean isActive);

    boolean existsByStaffCode(String staffCode);

    boolean existsByUsername(String Username);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

}