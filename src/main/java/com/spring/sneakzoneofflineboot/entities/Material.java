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
@Table(name = "materials")
public class Material {
     @Id
     @Size(max = 255)
     @ColumnDefault("uuid()")
     @Column(name = "id", nullable = false)
     private String id;

     @Size(max = 100)
     @NotNull
     @Column(name = "material_code", nullable = false, length = 100)
     private String materialCode;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "material_name")
     private String materialName;

     @Size(max = 255)
     @ColumnDefault("''")
     @Column(name = "description")
     private String description;

}