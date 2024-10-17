package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Category;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.CategoryRepository;
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
public class CategoryService implements UtilityServices <Category, String>{
     CategoryRepository categoryRepository;

     @Override
     public List<Category> getAll() {
          return categoryRepository.findAll();
     }

     @Override
     public Category getById(String id) {
          return categoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
     }

     @Override
     public Category save(Category entity) {
          return categoryRepository.save(entity);
     }

     @Override
     public Category update(Category entity, String id) {
          if (!categoryRepository.existsById(id)) {
               throw new AppException(ErrorCode.CATEGORY_NOT_EXISTED);
          }
          entity.setId(id);
          return categoryRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if (!categoryRepository.existsById(id)) {
               throw new AppException(ErrorCode.CATEGORY_NOT_EXISTED);
          }
          categoryRepository.deleteById(id);
     }

     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public Category getByName(String name) {
          return categoryRepository.getCategoryByCategoryName(name).orElse(null);
     }
}
