package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.Product;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.ProductRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements UtilityServices<Product, String> {
     ProductRepository productRepository;

     @Override
     public List<Product> getAll() {
          return List.of();
     }

     public boolean existsByIdBrand(String idBrand){
          return productRepository.existsByIdBrand(idBrand);
     }

     public boolean existsByIdCategory(String idCategory){
          return productRepository.existsByIdCategory(idCategory);
     }

     @Override
     public Product getById(String id) {
          return productRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
     }

     @Override
     public Product save(Product entity) {
          return productRepository.save(entity);
     }

     @Override
     public Product update(Product entity, String id) {
          if (!productRepository.existsById(id)) {
               throw new AppException(ErrorCode.PRODUCT_NOT_EXISTED);
          }
          entity.setId(id);
          return productRepository.save(entity);
     }

     @Override
     public void deleteById(String id) {
          if (!productRepository.existsById(id)) {
               throw new AppException(ErrorCode.PRODUCT_NOT_EXISTED);
          }
          productRepository.deleteById(id);
     }

     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public Product getByName(String name) {
          return null;
     }
}
