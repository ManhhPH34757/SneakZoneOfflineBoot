package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Brand;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.BrandRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandService implements UtilityServices<Brand, String> {
     BrandRepository brandRepository;

     @Override
     public List<Brand> getAll() {
          return brandRepository.findAll();
     }

     @Override
     public Brand getById(String id) {
          return brandRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_EXISTED));
     }

     @Override
     public Brand save(Brand entity) {
          return brandRepository.save(entity);
     }

     @Override
     public Brand update(Brand entity, String id) {
          if (!brandRepository.existsById(id)) {
               throw new AppException(ErrorCode.BRAND_NOT_EXISTED);
          }
          entity.setId(id);
          return brandRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if (!brandRepository.existsById(id)) {
               throw new AppException(ErrorCode.BRAND_NOT_EXISTED);
          }
          brandRepository.deleteById(id);
     }

     @Override
     public Boolean findByName(String name) {
          return (getByName(name) != null);
     }

     @Override
     public Brand getByName(String name) {
          return brandRepository.getBrandByBrandName(name).orElse(null);
     }
}
