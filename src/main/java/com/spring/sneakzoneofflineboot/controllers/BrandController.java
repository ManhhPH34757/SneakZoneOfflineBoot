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

     @GetMapping("/findByName")
     @Override
     public ApiResponse<Brand> getByName(@RequestParam(defaultValue = "") String name) {
          return super.getByName(name);
     }
}
