package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.ProductImage;
import com.spring.sneakzoneofflineboot.services.ProductImageService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-images")
public class ProductImageController extends UtilityController<ProductImage, String> {
     private final ProductImageService productImageService;

     public ProductImageController(UtilityServices<ProductImage, String> utilityServices, ProductImageService productImageService, ProductImageService productImageService1) {
          super(utilityServices);
          this.productImageService = productImageService1;
     }

     @PostMapping()
     @Override
     public ApiResponse<ProductImage> save(ProductImage entity) {
          return super.save(entity);
     }

     @GetMapping("/{idProduct}")
     public ApiResponse<List<ProductImage>> getByIdProduct(@PathVariable String idProduct) {
          return ApiResponse.<List<ProductImage>>builder()
               .result(productImageService.getAllByIdProduct(idProduct))
               .build();
     }
}
