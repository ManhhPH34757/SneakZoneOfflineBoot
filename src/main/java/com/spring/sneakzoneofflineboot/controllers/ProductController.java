package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.dto.response.ProductResponse;
import com.spring.sneakzoneofflineboot.entities.Product;
import com.spring.sneakzoneofflineboot.services.ProductResponseService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends UtilityController<Product, String> {
     private final ProductResponseService productResponseService;

     public ProductController(UtilityServices<Product, String> utilityServices, ProductResponseService productResponseService) {
          super(utilityServices);
          this.productResponseService = productResponseService;
     }

     @GetMapping()
     public ApiResponse<Page<ProductResponse>> getProductsResponse(
          @RequestHeader(value = "page", defaultValue = "0") int page,
          @RequestHeader(value = "size", defaultValue = "5") int size
     ) {
          Pageable pageable = PageRequest.of(page, size);
          return ApiResponse.<Page<ProductResponse>>builder()
               .result(productResponseService.getProductsResponse(pageable))
               .build();
     }

     @PostMapping()
     @Override
     public ApiResponse<Product> save(@RequestBody Product entity) {
          return super.save(entity);
     }

     @GetMapping("/{id}")
     @Override
     public ApiResponse<Product> getById(@PathVariable String id) {
          return super.getById(id);
     }
}
