package com.spring.sneakzoneofflineboot.controllers;


import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Staff;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController extends UtilityController<Staff, String> {

    public StaffController(UtilityServices<Staff, String> utilityServices) {
        super(utilityServices);
    }

    @GetMapping()
    @Override
    public ApiResponse<List<Staff>> getAll() {
        return super.getAll();
    }

}
