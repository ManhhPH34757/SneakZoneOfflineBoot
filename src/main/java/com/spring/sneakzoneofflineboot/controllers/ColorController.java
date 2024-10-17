package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.Color;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public ApiResponse<Color> save(Color entity) {
        return super.save(entity);
    }

    @Override
    public ApiResponse<Color> update(Color entity, String id) {
        return super.update(entity, id);
    }

    @Override
    public ApiResponse<Void> deleteById(String id) {
        return super.deleteById(id);
    }

    @GetMapping("/findByName")
    @Override
    public ApiResponse<Color> getByName(String name) {
        return super.getByName(name);
    }
}
