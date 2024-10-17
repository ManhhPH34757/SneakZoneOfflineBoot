package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {


     @Query(value ="SELECT s.id,s.staff_code,s.full_name,s.gender,s.birthday,s.phone_number,s.address,s.email,s.username,s.password,s.role,s.created_at,s.updated_at,s.is_active From staffs s "
             ,nativeQuery = true)
     List<Staff> getAll();

     Optional<Staff> findByUsername(String username);

     boolean existsByStaffCode(String staffCode);
     boolean existsByUsername(String Username);
     boolean existsByEmail(String email);
     boolean existsByPhoneNumber(String phoneNumber);


}