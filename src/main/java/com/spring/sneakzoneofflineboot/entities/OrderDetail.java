package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @Size(max = 255)
    @ColumnDefault("uuid()")
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 255)
    @NotNull
    @Column(name = "id_orders", nullable = false)
    private String idOrders;

    @Size(max = 255)
    @NotNull
    @Column(name = "id_product_details", nullable = false)
    private String idProductDetails;

    @ColumnDefault("0")
    @Column(name = "quantity")
    private Integer quantity;

    @ColumnDefault("0.00000")
    @Column(name = "total_price", precision = 65, scale = 5)
    private BigDecimal totalPrice;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "status")
    private String status;

}