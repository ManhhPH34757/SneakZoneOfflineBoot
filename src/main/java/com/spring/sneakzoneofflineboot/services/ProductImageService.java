package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.ProductImage;
import com.spring.sneakzoneofflineboot.repositories.ProductImageRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductImageService implements UtilityServices<ProductImage, String> {
     ProductImageRepository productImageRepository;

     public List<ProductImage> getAllByIdProduct(String id) {
          return productImageRepository.findProductImagesByIdProduct(id);
     }

     @Override
     public List<ProductImage> getAll() {
          return List.of();
     }

     @Override
     public ProductImage getById(String id) {
          return null;
     }

     @Override
     public ProductImage save(ProductImage entity) {
          return productImageRepository.save(entity);
     }

     @Override
     public ProductImage update(ProductImage entity, String id) {
          return null;
     }

     @Override
     public void deleteById(String id) {

     }
}
