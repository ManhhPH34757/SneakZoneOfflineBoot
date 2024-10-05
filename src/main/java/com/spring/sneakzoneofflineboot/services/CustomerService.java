package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.dto.response.CustomerResponse;
import com.spring.sneakzoneofflineboot.entities.Customer;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.mapper.CustomerMapper;
import com.spring.sneakzoneofflineboot.repositories.CustomerRepository;
import com.spring.sneakzoneofflineboot.repositories.CustomerResponseRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService implements UtilityServices<Customer, String> {
    CustomerResponseRepository customerResponseRepository;
    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public Page<CustomerResponse> getAllCustomer(Pageable pageable){
        return customerResponseRepository.getAllCustomer(pageable);
    }

    public CustomerResponse findById(String id){
        if (!customerRepository.existsById(id)){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        return customerMapper.toCustomerRespone(customerRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public Customer getById(String id) {
        return null;
    }

    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public Customer update(Customer entity, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
