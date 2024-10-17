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

    public Page<CustomerResponse> getAllCustomer(String fullNameOrPhoneNumber,Pageable pageable){
        return customerResponseRepository.getCustomers(fullNameOrPhoneNumber,pageable);
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
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Customer update(Customer entity, String id) {
        if(!customerRepository.existsById(id)){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        entity.setId(id);
        return customerRepository.save(entity);

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public Customer getByName(String name) {
        return null;
    }

    public Boolean checkExistsCustomerCode(String customerCode){
        return customerRepository.existsByCustomerCode(customerCode);
    }

    public Boolean checkExistsPhoneNumber(String phoneNumber){
        return customerRepository.existsByPhoneNumber(phoneNumber);
    }

    public Boolean checkExistsEmail(String email){
        return customerRepository.existsByEmail(email);
    }
}
