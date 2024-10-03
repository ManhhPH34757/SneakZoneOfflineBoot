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
               "GROUP BY p.id, p.product_code, p.product_name, b.brand_name, c.category_name, s.sole_name, m.material_name, p.created_at, p.updated_at ",
          nativeQuery = true
     )
     Page<ProductResponse> getProductsResponse(Pageable pageable);

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
}