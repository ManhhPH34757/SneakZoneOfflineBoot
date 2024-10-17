package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Customer;
import com.spring.sneakzoneofflineboot.mapper.CustomerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Boolean existsByCustomerCode(String customerCode);
    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);

}