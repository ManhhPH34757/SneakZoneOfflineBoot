package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}