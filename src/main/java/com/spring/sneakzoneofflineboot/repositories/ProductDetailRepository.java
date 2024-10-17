package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {

    Boolean existsByIdProductAndIdColorAndIdSize(String idProduct, String idColor, String idSize);

    List<ProductDetail> getProductDetailsByIdProduct(String idProduct);

    Boolean existsByIdProduct(String idProduct);
}