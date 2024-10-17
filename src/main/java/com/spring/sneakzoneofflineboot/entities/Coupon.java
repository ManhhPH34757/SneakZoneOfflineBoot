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
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @Size(max = 255)
    @ColumnDefault("uuid()")
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 100)
    @NotNull
    @Column(name = "coupons_code", nullable = false, length = 100)
    private String couponsCode;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "coupons_name")
    private String couponsName;

    @ColumnDefault("0.00000")
    @Column(name = "conditions", precision = 65, scale = 5)
    private BigDecimal conditions;

    @ColumnDefault("0.00000")
    @Column(name = "coupons_price", precision = 65, scale = 5)
    private BigDecimal couponsPrice;

    @ColumnDefault("0")
    @Column(name = "quantity")
    private Integer quantity;

    @ColumnDefault("current_timestamp()")
    @Column(name = "start_date")
    private Instant startDate;

    @ColumnDefault("current_timestamp()")
    @Column(name = "end_date")
    private Instant endDate;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}