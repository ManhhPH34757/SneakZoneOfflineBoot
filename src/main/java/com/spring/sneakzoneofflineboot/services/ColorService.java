package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Color;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.ColorRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ColorService implements UtilityServices <Color, String> {
     ColorRepository colorRepository;

     @Override
     public List<Color> getAll() {
          return colorRepository.findAll();
     }

     @Override
     public Color getById(String id) {
          return colorRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXISTED));
     }

     @Override
     public Color save(Color entity) {
          return colorRepository.save(entity);
     }

     @Override
     public Color update(Color entity, String id) {
          if(!colorRepository.existsById(id)){
               throw new AppException(ErrorCode.COLOR_NOT_EXISTED);
          }
          entity.setId(id);
          return colorRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if(!colorRepository.existsById(id)){
               throw new AppException(ErrorCode.COLOR_NOT_EXISTED);
          }
          colorRepository.deleteById(id);
     }


     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public Color getByName(String name) {
          return null;
     }
}
