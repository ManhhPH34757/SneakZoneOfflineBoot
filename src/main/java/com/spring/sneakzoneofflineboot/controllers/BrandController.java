package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Brand;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController extends UtilityController<Brand, String> {

     public BrandController(UtilityServices<Brand, String> utilityServices) {
          super(utilityServices);
     }

     @GetMapping()
     @Override
     public ApiResponse<List<Brand>> getAll() {
          return super.getAll();
     }

     @GetMapping("/{id}")
     @Override
     public ApiResponse<Brand> getById(@PathVariable String id) {
          return super.getById(id);
     }

}
