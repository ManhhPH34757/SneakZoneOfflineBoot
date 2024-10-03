package com.spring.sneakzoneofflineboot.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
     @Id
     String id;
     String productCode;
     String productName;
     String brandName;
     String categoryName;
     String soleName;
     String materialName;
     Instant createdAt;
     Instant updatedAt;
     Integer quantity;
}
