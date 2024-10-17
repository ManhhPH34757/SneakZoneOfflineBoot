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
@Table(name = "orders")
public class Order {
    @Id
    @Size(max = 255)
    @ColumnDefault("uuid()")
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 100)
    @NotNull
    @Column(name = "order_code", nullable = false, length = 100)
    private String orderCode;

    @Size(max = 255)
    @Column(name = "id_customer")
    private String idCustomer;

    @Size(max = 255)
    @NotNull
    @Column(name = "id_staff", nullable = false)
    private String idStaff;

    @Size(max = 255)
    @Column(name = "id_coupons")
    private String idCoupons;

    @Size(max = 100)
    @ColumnDefault("''")
    @Column(name = "customer_name", length = 100)
    private String customerName;

    @Size(max = 13)
    @ColumnDefault("''")
    @Column(name = "phone_number", length = 13)
    private String phoneNumber;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "address")
    private String address;

    @ColumnDefault("0.00000")
    @Column(name = "transport_price", precision = 65, scale = 5)
    private BigDecimal transportPrice;

    @ColumnDefault("0.00000")
    @Column(name = "reduced_price", precision = 65, scale = 5)
    private BigDecimal reducedPrice;

    @ColumnDefault("0.00000")
    @Column(name = "total_price", precision = 65, scale = 5)
    private BigDecimal totalPrice;

    @ColumnDefault("0.00000")
    @Column(name = "total_payouts", precision = 65, scale = 5)
    private BigDecimal totalPayouts;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "order_type")
    private String orderType;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "status")
    private String status;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}