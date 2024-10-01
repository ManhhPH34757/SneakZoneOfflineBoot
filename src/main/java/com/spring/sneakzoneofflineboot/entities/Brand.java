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

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "brand_code", nullable = false, length = 100)
     private String brandCode;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "brand_name")
     private String brandName;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "description")
     private String description;

}