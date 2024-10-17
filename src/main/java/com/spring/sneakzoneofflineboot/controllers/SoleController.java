package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Sole;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soles")
public class SoleController extends UtilityController <Sole, String> {

     public SoleController(UtilityServices<Sole, String> utilityServices) {
          super(utilityServices);
     }

     @GetMapping()
     @Override
     public ApiResponse<List<Sole>> getAll() {
          return super.getAll();
     }

     @GetMapping("/{id}")
     @Override
     public ApiResponse<Sole> getById(@PathVariable String id) {
          return super.getById(id);
     }

     @PostMapping()
     @Override
     public ApiResponse<Sole> save(@RequestBody Sole entity) {
          return super.save(entity);
     }

     @PutMapping("/{id}")
     @Override
     public ApiResponse<Sole> update(@RequestBody Sole entity, @PathVariable String id) {
          return super.update(entity, id);
     }

     @DeleteMapping("/{id}")
     @Override
     public ApiResponse<Void> deleteById(@PathVariable String id) {
          return super.deleteById(id);
     }

     @GetMapping("/findByName")
     @Override
     public ApiResponse<Sole> getByName(String name) {
          return super.getByName(name);
     }
}
