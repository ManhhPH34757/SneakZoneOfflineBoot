package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Brand;
import com.spring.sneakzoneofflineboot.services.BrandService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController extends UtilityController<Brand, String> {

     private final BrandService brandService;

     public BrandController(UtilityServices<Brand, String> utilityServices, BrandService brandService) {
          super(utilityServices);
          this.brandService = brandService;
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

     @PostMapping()
     @Override
     public ApiResponse<Brand> save(@RequestBody Brand entity) {
          return super.save(entity);
     }

     @PutMapping("/{id}")
     @Override
     public ApiResponse<Brand> update(@RequestBody Brand entity, @PathVariable String id) {
          return super.update(entity, id);
     }

     @DeleteMapping("/{id}")
     @Override
     public ApiResponse<Void> deleteById(@PathVariable String id) {
          return super.deleteById(id);
     }
}
