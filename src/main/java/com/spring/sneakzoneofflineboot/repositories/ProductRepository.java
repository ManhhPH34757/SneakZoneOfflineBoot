package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Boolean existsByProductCode(String productCode);

    Boolean existsByProductName(String name);

    Optional<Product> getProductByProductCode(String productCode);

    boolean existsByIdBrand(String idBrand);

    boolean existsByIdCategory(String idCategory);

}