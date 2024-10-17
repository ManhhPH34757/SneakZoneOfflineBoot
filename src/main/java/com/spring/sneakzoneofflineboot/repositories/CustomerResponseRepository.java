package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.dto.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerResponseRepository extends JpaRepository<CustomerResponse, String> {

    @Query(
            value = "SELECT " +
                    "c.id as id, " +
                    "c.customer_code as customer_code, " +
                    "c.full_name as full_name, " +
                    "c.gender as gender, " +
                    "c.birthday as birthday, " +
                    "c.phone_number as phone_number, " +
                    "c.address as address, " +
                    "c.email as email, " +
                    "c.accumulated_points as accumulated_points, " +
                    "c.created_at as created_at, " +
                    "c.updated_at as updated_at "+
                    "FROM customers c " +
                    "WHERE c.full_name LIKE CONCAT('%',?1, '%' ) " +
                    "OR (c.phone_number LIKE  CONCAT(?1, '%' )  " +
                    "OR  ?1 IS NULL )",
            nativeQuery = true
    )
    Page<CustomerResponse> getCustomers(String fullNameOrPhoneNumber, Pageable pageable);

}
