package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @Size(max = 255)
    @ColumnDefault("uuid()")
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 100)
    @NotNull
    @Column(name = "sale_code", nullable = false, length = 100)
    private String saleCode;

    @Size(max = 255)
    @ColumnDefault("''")
    @Column(name = "sale_name")
    private String saleName;

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