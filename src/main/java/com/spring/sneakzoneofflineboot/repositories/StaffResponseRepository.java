package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffResponseRepository extends JpaRepository<StaffResponse, String> {

    @Query(value = "SELECT " +
            "s.id AS id, " +
            "s.staff_code AS staff_code, " +
            "s.full_name AS full_name, " +
            "s.gender AS gender, " +
            "s.birthday AS birthday, " +
            "s.phone_number AS phone_number, " +
            "s.address AS address, " +
            "s.email AS email, " +
            "s.username AS username, " +
            "s.role AS role, " +
            "s.created_at AS created_at, " +
            "s.updated_at AS updated_at, " +
            "s.is_active AS is_active " +
            "FROM staffs s " +
            "WHERE (s.staff_code LIKE CONCAT(?1, '%') OR ?1 IS NULL) " +
            "AND (s.full_name LIKE CONCAT(?2, '%') OR ?2 IS NULL) " +
            "AND (s.gender = ?3 OR ?3 IS NULL) " +
            "AND (s.email LIKE CONCAT(?4 , '%') OR ?4 IS NULL) " +
            "AND (s.is_active = ?5 OR ?5 IS NULL) " +
            "AND (s.phone_number LIKE CONCAT(?6 , '%') OR ?6 IS NULL)",
            nativeQuery = true)
    Page<StaffResponse> filter(String staffCode, String fullName, String gender, String email, String isActive, String phoneNumber, Pageable pageable);
}