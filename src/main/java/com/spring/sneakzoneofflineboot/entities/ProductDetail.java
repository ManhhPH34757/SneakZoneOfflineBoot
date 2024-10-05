package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_details")
public class ProductDetail {
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
     @NotNull
     @Column(name = "id_color", nullable = false)
     private String idColor;

     @Size(max = 255)
     @NotNull
     @Column(name = "id_size", nullable = false)
     private String idSize;

     @ColumnDefault("0")
     @Column(name = "weight")
     private Float weight;

     @ColumnDefault("0.00000")
     @Column(name = "price", precision = 65, scale = 5)
     private BigDecimal price;

     @ColumnDefault("0")
     @Column(name = "quantity")
     private Integer quantity;

     @Size(max = 30)
     @ColumnDefault("''")
     @Column(name = "status", length = 30)
     private String status;

     @ColumnDefault("current_timestamp()")
     @Column(name = "created_at")
     private Instant createdAt;

     @ColumnDefault("current_timestamp()")
     @Column(name = "updated_at")
     private Instant updatedAt;

}