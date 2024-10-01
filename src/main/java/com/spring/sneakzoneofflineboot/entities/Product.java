package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "product_code", nullable = false, length = 100)
     private String productCode;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "product_name")
     private String productName;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_brand", nullable = false)
     private String idBrand;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_category", nullable = false)
     private String idCategory;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_sole", nullable = false)
     private String idSole;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_material", nullable = false)
     private String idMaterial;

     @ColumnDefault("current_timestamp()")
     @Column(name = "created_at")
     private Instant createdAt;

     @ColumnDefault("current_timestamp()")
     @Column(name = "updated_at")
     private Instant updatedAt;

}