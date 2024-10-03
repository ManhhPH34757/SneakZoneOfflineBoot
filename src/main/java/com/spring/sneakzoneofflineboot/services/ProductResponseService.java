package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.dto.response.ProductResponse;
import com.spring.sneakzoneofflineboot.enums.ErrorCode;
import com.spring.sneakzoneofflineboot.exceptions.AppException;
import com.spring.sneakzoneofflineboot.repositories.ProductResponseRepository;
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
public class ProductResponseService implements UtilityServices<ProductResponse, String> {
     ProductResponseRepository productResponseRepository;

     public Page<ProductResponse> getProductsResponse(Pageable pageable) {
          return productResponseRepository.getProductsResponse(pageable);
     }

     @Override
     public List<ProductResponse> getAll() {
          return List.of();
     }

     @Override
     public ProductResponse getById(String id) {
          return productResponseRepository.findProductResponseById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
     }

     @Override
     public ProductResponse save(ProductResponse entity) {
          return null;
     }

     @Override
     public ProductResponse update(ProductResponse entity, String id) {
          return null;
     }

     @Override
     public void deleteById(String id) {

     }
}
