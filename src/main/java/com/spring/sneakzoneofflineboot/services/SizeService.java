package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Size;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.SizeRepository;
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
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(String id) {
        return sizeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_EXISTED));
    }

    @Override
    public Size save(Size entity) {
        return sizeRepository.save(entity);
    }

    @Override
    public Size update(Size entity, String id) {
        if (!sizeRepository.existsById(id)) {
            throw new AppException(ErrorCode.SIZE_NOT_EXISTED);
        }
        entity.setId(id);
        return sizeRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        if (!sizeRepository.existsById(id)) {
            throw new AppException(ErrorCode.SIZE_NOT_EXISTED);
        }
        sizeRepository.deleteById(id);
    }

    @Override
    public Boolean findByName(String name) {
        return false;
    }

    @Override
    public Size getByName(String name) {
        return sizeRepository.getSizeBySizeName(name).orElse(null);
    }
}
