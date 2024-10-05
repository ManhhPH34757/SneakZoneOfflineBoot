package com.spring.sneakzoneofflineboot.mapper;


import com.spring.sneakzoneofflineboot.dto.response.CustomerResponse;
import com.spring.sneakzoneofflineboot.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerResponse toCustomerRespone(Customer customer);
}
