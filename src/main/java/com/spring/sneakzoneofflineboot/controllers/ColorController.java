package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Color;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController extends UtilityController<Color, String> {
    public ColorController(UtilityServices<Color, String> utilityServices) {
        super(utilityServices);
    }
    @GetMapping()
    @Override
    public ApiResponse<List<Color>> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public ApiResponse<Color> getById(@PathVariable String id) {
        return super.getById(id);
    }

    @PostMapping()
    @Override
    public ApiResponse<Color> save(@RequestBody Color entity) {
        return super.save(entity);
    }

    @PutMapping("/{id}")
    @Override
    public ApiResponse<Color> update(@RequestBody Color entity, @PathVariable String id) {
        return super.update(entity, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ApiResponse<Void> deleteById(@PathVariable String id) {
        return super.deleteById(id);
    }


}
