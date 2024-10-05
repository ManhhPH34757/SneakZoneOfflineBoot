package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_product", nullable = false)
     private String idProduct;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "images")
     private String images;

}