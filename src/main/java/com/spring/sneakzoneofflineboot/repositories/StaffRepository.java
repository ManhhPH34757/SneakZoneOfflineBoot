package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

     Optional<Staff> findByUsername(String username);
}