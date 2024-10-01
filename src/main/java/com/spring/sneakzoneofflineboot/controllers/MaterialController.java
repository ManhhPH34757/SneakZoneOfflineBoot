package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Material;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController extends UtilityController <Material, String> {

     public MaterialController(UtilityServices<Material, String> utilityServices) {
          super(utilityServices);
     }

     @GetMapping()
     @Override
     public ApiResponse<List<Material>> getAll() {
          return super.getAll();
     }

     @GetMapping("/{id}")
     @Override
     public ApiResponse<Material> getById(@PathVariable String id) {
          return super.getById(id);
     }
}
