package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.dto.response.CustomerResponse;
import com.spring.sneakzoneofflineboot.entities.Customer;
import com.spring.sneakzoneofflineboot.services.CustomerService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends UtilityController<Customer, String> {
    private final CustomerService customerService;

    public CustomerController(UtilityServices<Customer, String> utilityServices, CustomerService customerService) {
        super(utilityServices);
        this.customerService = customerService;
    }

    @GetMapping()
    public ApiResponse<Page<CustomerResponse>> getAllCustomer(
            @RequestHeader(name = "page", defaultValue = "0") Integer page,
            @RequestHeader(name = "size", defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("updated_at").descending());
        return ApiResponse.<Page<CustomerResponse>>builder()
                .result(customerService.getAllCustomer(pageable))
                .build();
    }

    @GetMapping("/{id}")
    @Override
    public ApiResponse<Customer> getById(@PathVariable String id) {
        return super.getById(id);
    }

    @PostMapping()
    @Override
    public ApiResponse<Customer> save(@RequestBody Customer entity) {
        return super.save(entity);
    }

    @PutMapping("/{id}")
    @Override
    public ApiResponse<Customer> update(@RequestBody Customer entity, @PathVariable String id) {
        return super.update(entity, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ApiResponse<Void> deleteById(@PathVariable String id) {
        return super.deleteById(id);
    }
}

