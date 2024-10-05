package com.spring.sneakzoneofflineboot.repositories;

import com.spring.sneakzoneofflineboot.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductResponseRepository extends JpaRepository<ProductResponse, String> {

     @Query(
          value = "SELECT " +
               "p.id as 'id', " +
               "p.product_code as 'product_code', " +
               "p.product_name as 'product_name', " +
               "b.brand_name as 'brand_name', " +
               "c.category_name as 'category_name', " +
               "s.sole_name as 'sole_name'," +
               "m.material_name as 'material_name'," +
               "p.created_at as 'created_at', " +
               "p.updated_at as 'updated_at'," +
               "COALESCE(SUM(pd.quantity), 0) AS 'quantity' " +
               "FROM products p join brands b on p.id_brand = b.id " +
               "join categories c on p.id_category = c.id " +
               "join materials m on p.id_material = m.id " +
               "join soles s on p.id_sole = s.id " +
               "left join product_details pd on p.id = pd.id_product " +
               "WHERE p.id = ?1 " +
               "GROUP BY p.id, p.product_code, p.product_name, b.brand_name, c.category_name, s.sole_name, m.material_name, p.created_at, p.updated_at ",
          nativeQuery = true
     )
     Optional<ProductResponse> findProductResponseById(String id);

     @Query(
             value = "SELECT " +
                     "p.id AS id, " +
                     "p.product_code AS product_code, " +
                     "p.product_name AS product_name, " +
                     "b.brand_name AS brand_name, " +
                     "c.category_name AS category_name, " +
                     "s.sole_name AS sole_name, " +
                     "m.material_name AS material_name, " +
                     "p.created_at AS created_at, " +
                     "p.updated_at AS updated_at, " +
                     "COALESCE(SUM(pd.quantity), 0) AS quantity " +
                     "FROM products p " +
                     "JOIN brands b ON p.id_brand = b.id " +
                     "JOIN categories c ON p.id_category = c.id " +
                     "JOIN materials m ON p.id_material = m.id " +
                     "JOIN soles s ON p.id_sole = s.id " +
                     "LEFT JOIN product_details pd ON p.id = pd.id_product " +
                     "WHERE ( p.product_name LIKE CONCAT(?1, '%') OR ?1 IS NULL ) " +
                     "AND ( b.id = ?2 OR ?2 IS NULL ) " +
                     "AND ( c.id = ?3 OR ?3 IS NULL ) " +
                     "AND ( m.id = ?4 OR ?4 IS NULL ) " +
                     "AND ( s.id = ?5 OR ?5 IS NULL ) " +
                     "GROUP BY p.id, p.product_code, p.product_name, b.brand_name, c.category_name, s.sole_name, m.material_name, p.created_at, p.updated_at " +
                     "HAVING ( ?6 IS NOT NULL AND COALESCE(SUM(pd.quantity), 0) >= ?6 OR ?6 IS NULL ) " +
                     "AND ( ?7 IS NOT NULL AND COALESCE(SUM(pd.quantity), 0) <= ?7 OR ?7 IS NULL ) ",
             nativeQuery = true
     )
     Page<ProductResponse> filter(String productName, String idBrand, String idCategory, String idMaterial, String idSole, Integer min, Integer max, Pageable pageable);
}