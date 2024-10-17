package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Brand;
import com.spring.sneakzoneofflineboot.entities.Category;
import com.spring.sneakzoneofflineboot.services.CategoryService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends UtilityController<Category, String> {

     public CategoryController(UtilityServices<Category, String> utilityServices) {
          super(utilityServices);
     }

     @GetMapping()
     @Override
     public ApiResponse<List<Category>> getAll() {
          return super.getAll();
     }

     @GetMapping("/{id}")
     @Override
     public ApiResponse<Category> getById(@PathVariable String id) {
          return super.getById(id);
     }

     @PostMapping()
     @Override
     public ApiResponse<Category> save(@RequestBody Category entity) {
          return super.save(entity);
     }

     @PutMapping("/{id}")
     @Override
     public ApiResponse<Category> update(@RequestBody Category entity, @PathVariable String id) {
          return super.update(entity, id);
     }

     @DeleteMapping("/{id}")
     @Override
     public ApiResponse<Void> deleteById(@PathVariable String id) {
          return super.deleteById(id);
     }
}
