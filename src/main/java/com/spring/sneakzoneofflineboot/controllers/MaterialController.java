package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Material;
import com.spring.sneakzoneofflineboot.services.MaterialService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

     @PostMapping()
     @Override
     public ApiResponse<Material> save(@RequestBody Material entity) {
          return super.save(entity);
     }

     @PutMapping("/{id}")
     @Override
     public ApiResponse<Material> update(@RequestBody Material entity, @PathVariable String id) {
          return super.update(entity, id);
     }

     @DeleteMapping("/{id}")
     @Override
     public ApiResponse<Void> deleteById(@PathVariable String id) {
          return super.deleteById(id);
     }
}
