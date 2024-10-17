package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Sole;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.SoleRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SoleService implements UtilityServices <Sole, String> {
     SoleRepository soleRepository;

     @Override
     public List<Sole> getAll() {
          return soleRepository.findAll();
     }

     @Override
     public Sole getById(String id) {
          return soleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SOLE_NOT_EXISTED));
     }

     @Override
     public Sole save(Sole entity) {
          return soleRepository.save(entity);
     }

     @Override
     public Sole update(Sole entity, String id) {
          if (!soleRepository.existsById(id)) {
               throw new AppException(ErrorCode.SOLE_NOT_EXISTED);
          }
          entity.setId(id);
          return soleRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if (!soleRepository.existsById(id)) {
               throw new AppException(ErrorCode.SOLE_NOT_EXISTED);
          }
          soleRepository.deleteById(id);
     }

     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public Sole getByName(String name) {
          return soleRepository.getSoleBySoleName(name).orElse(null);
     }
}
