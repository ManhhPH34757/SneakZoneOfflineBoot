package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {

     List<ProductImage> findProductImagesByIdProduct(String idProduct);

     void deleteProductImagesByIdProduct(String idProduct);
}