package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Size;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
public class SizeController extends UtilityController<Size,String> {
    public SizeController(UtilityServices<Size, String> utilityServices) {
        super(utilityServices);
    }

    @Override
    public ApiResponse<List<Size>> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public ApiResponse<Size> getById(@PathVariable String id) {
        return super.getById(id);
    }

    @PostMapping()
    @Override
    public ApiResponse<Size> save(Size entity) {
        return super.save(entity);
    }

    @PutMapping()
    @Override
    public ApiResponse<Size> update(@RequestBody Size entity,@PathVariable String id) {
        return super.update(entity, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ApiResponse<Void> deleteById(@PathVariable String id) {
        return super.deleteById(id);
    }
}
