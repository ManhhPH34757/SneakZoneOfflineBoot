package com.spring.sneakzoneofflineboot.controllers;


import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.dto.response.StaffResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import com.spring.sneakzoneofflineboot.repositories.ProductRepository;
import com.spring.sneakzoneofflineboot.repositories.StaffRepository;
import com.spring.sneakzoneofflineboot.services.StaffResponseService;
import com.spring.sneakzoneofflineboot.services.StaffService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController extends UtilityController<Staff, String> {


    StaffRepository staffRepository;
    PasswordEncoder passwordEncoder;
    StaffService staffService;
    StaffResponseService staffResponseService;

    public StaffController(UtilityServices<Staff, String> utilityServices,
                           StaffRepository staffRepository, PasswordEncoder passwordEncoder, StaffService staffService, StaffResponseService staffResponseService) {
        super(utilityServices);
        this.staffRepository = staffRepository;
        this.passwordEncoder = passwordEncoder;
        this.staffService = staffService;
        this.staffResponseService = staffResponseService;
    }

    @GetMapping()
    public ApiResponse<Page<StaffResponse>> getAll(@RequestParam(required = false) String staffCode,
                                           @RequestParam (required = false) String fullName,
                                           @RequestParam(required = false) String gender,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String isActive,
                                           @RequestParam(required = false) String phoneNumber,
                                           @RequestHeader(value = "page", defaultValue = "0") int page,
                                           @RequestHeader(value = "size", defaultValue = "5") int size
                                           ) {
        Pageable pageable = PageRequest.of(page,size, Sort.by("created_at").descending());
        return ApiResponse.<Page<StaffResponse>>builder()
                .result(staffResponseService.filerStaffs(staffCode,fullName,gender,email,isActive,phoneNumber,pageable))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<Staff> getById(@PathVariable String id) {
        return super.getById(id);
    }


    @PostMapping()
    public ApiResponse<Staff> create(@RequestBody Staff staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return super.save(staff);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        return super.deleteById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Staff> update(@PathVariable String id, @RequestBody Staff staff) {
        return super.update(staff,id);
    }

    @GetMapping("/check-exists-staff-code")
    public ApiResponse<Boolean> checkExistsStaffCode(@RequestParam String staffCode) {
        return ApiResponse.<Boolean>builder()
                .result(staffService.findByStaffCode(staffCode))
                .build();
    }

    @GetMapping("/check-exists-staff-name")
    public ApiResponse<Boolean> checkExistsUsername(@RequestParam String username) {
        return ApiResponse.<Boolean>builder()
                .result(staffService.findByUsername(username))
                .build();
    }

    @GetMapping("/check-exists-staff-phoneNumber")
    public ApiResponse<Boolean> checkExistsphoneNumber(@RequestParam String phoneNumber) {
        return ApiResponse.<Boolean>builder()
                .result(staffService.findByPhoneNumber(phoneNumber))
                .build();
    }

    @GetMapping("/check-exists-staff-Email")
    public ApiResponse<Boolean> checkExistsEmail(@RequestParam String email) {
        return ApiResponse.<Boolean>builder()
                .result(staffService.findByEmail(email))
                .build();
    }

}
