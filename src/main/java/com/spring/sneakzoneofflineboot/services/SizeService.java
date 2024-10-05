package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Size;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SizeService implements UtilityServices<Size, String> {
    @Override
    public List<Size> getAll() {
        return List.of();
    }

    @Override
    public Size getById(String id) {
        return null;
    }

    @Override
    public Size save(Size entity) {
        return null;
    }

    @Override
    public Size update(Size entity, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public Size getByName(String name) {
        return null;
    }
}
