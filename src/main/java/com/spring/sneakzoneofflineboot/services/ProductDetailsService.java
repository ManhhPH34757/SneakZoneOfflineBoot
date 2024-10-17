package com.spring.sneakzoneofflineboot.services;

import com.spring.sneakzoneofflineboot.entities.ProductDetail;
import com.spring.sneakzoneofflineboot.repositories.ProductDetailRepository;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductDetailsService implements UtilityServices<ProductDetail, String> {
    ProductDetailRepository productDetailRepository;

    public List<ProductDetail> getProductDetailsByIdProduct(String idProduct) {
        return productDetailRepository.getProductDetailsByIdProduct(idProduct);
    }

    @Override
    public List<ProductDetail> getAll() {
        return List.of();
    }

    @Override
    public ProductDetail getById(String id) {
        return null;
    }

    @Override
    public ProductDetail save(ProductDetail entity) {
        return productDetailRepository.save(entity);
    }

    @Override
    public ProductDetail update(ProductDetail entity, String id) {
        entity.setId(id);
        return productDetailRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public ProductDetail getByName(String name) {
        return null;
    }

    public Boolean getByIdProductAndColorAndSize(String idProduct, String idColor, String idSize) {
        return productDetailRepository.existsByIdProductAndIdColorAndIdSize(idProduct, idColor, idSize);
    }

    public Boolean getByIdProduct(String idProduct) {
        return productDetailRepository.existsByIdProduct(idProduct);
    }
}
