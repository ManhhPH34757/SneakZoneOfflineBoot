package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Material;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.MaterialRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MaterialService implements UtilityServices <Material, String> {
     MaterialRepository materialRepository;

     @Override
     public List<Material> getAll() {
          return materialRepository.findAll();
     }

     @Override
     public Material getById(String id) {
          return materialRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.MATERIAL_NOT_EXISTED));
     }

     @Override
     public Material save(Material entity) {
          return materialRepository.save(entity);
     }

     @Override
     public Material update(Material entity, String id) {
          if (!materialRepository.existsById(id)) {
               throw new AppException(ErrorCode.MATERIAL_NOT_EXISTED);
          }
          entity.setId(id);
          return materialRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if (!materialRepository.existsById(id)) {
               throw new AppException(ErrorCode.MATERIAL_NOT_EXISTED);
          }
          materialRepository.deleteById(id);
     }

     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public Material getByName(String name) {
          return null;
     }
}
