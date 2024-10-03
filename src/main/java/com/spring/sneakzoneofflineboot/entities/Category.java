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
@Table(name = "categories")
public class Category {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "category_code", nullable = false, length = 100)
     private String categoryCode;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "category_name")
     private String categoryName;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "description")
     private String description;

}