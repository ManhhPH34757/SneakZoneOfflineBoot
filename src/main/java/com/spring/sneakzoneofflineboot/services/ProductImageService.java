package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.ProductImage;
import com.spring.sneakzoneofflineboot.repositories.ProductImageRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

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
          System.out.println(entity.getId());
          return productImageRepository.save(entity);
     }

     @Override
     public ProductImage update(ProductImage entity, String id) {
          return null;
     }

     @Transactional
     @Override
     public void deleteById(String idProduct) {
          productImageRepository.deleteProductImagesByIdProduct(idProduct);
     }

     @Override
     public Boolean findByName(String name) {
          return false;
     }

     @Override
     public ProductImage getByName(String name) {
          return null;
     }
}
