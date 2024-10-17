package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "product_details_sales")
public class ProductDetailsSale {
    @Id
    @Size(max = 255)
    @ColumnDefault("uuid()")
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 255)
    @NotNull
    @Column(name = "id_product_details", nullable = false)
    private String idProductDetails;

    @Size(max = 255)
    @NotNull
    @Column(name = "id_sale", nullable = false)
    private String idSale;

    @ColumnDefault("0")
    @Column(name = "percent")
    private Float percent;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}