package com.spring.sneakzoneofflineboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sizes")
public class Size {
     @Id
     @jakarta.validation.constraints.Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @jakarta.validation.constraints.Size(max = 100)
     @NotNull
     @Column(name = "size_code", nullable = false, length = 100)
     private String sizeCode;

     @jakarta.validation.constraints.Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "size_name")
     private String sizeName;

     @jakarta.validation.constraints.Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "description")
     private String description;

}