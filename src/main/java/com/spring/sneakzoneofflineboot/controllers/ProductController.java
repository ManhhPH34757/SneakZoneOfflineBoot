package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.dto.response.ProductResponse;
import com.spring.sneakzoneofflineboot.entities.Product;
import com.spring.sneakzoneofflineboot.services.ProductResponseService;
import com.spring.sneakzoneofflineboot.services.ProductService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController extends UtilityController<Product, String> {
    private final ProductResponseService productResponseService;
    private final ProductService productService;

    public ProductController(UtilityServices<Product, String> utilityServices, ProductResponseService productResponseService, ProductService productService) {
        super(utilityServices);
        this.productResponseService = productResponseService;
        this.productService = productService;
    }

    @GetMapping()
    public ApiResponse<Page<ProductResponse>> filterProducts(@RequestParam(required = false) String productName,
                                                             @RequestParam(required = false) String idBrand,
                                                             @RequestParam(required = false) String idCategory,
                                                             @RequestParam(required = false) String idMaterial,
                                                             @RequestParam(required = false) String idSole,
                                                             @RequestParam(required = false) Integer min,
                                                             @RequestParam(required = false) Integer max,
                                                             @RequestHeader(value = "page", defaultValue = "0") int page,
                                                             @RequestHeader(value = "size", defaultValue = "5") int size
                                                             ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("updated_at").descending());
        return ApiResponse.<Page<ProductResponse>>builder()
                .result(productResponseService.filterProducts(productName, idBrand, idCategory, idMaterial, idSole, min, max, pageable))
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

    @PutMapping("/{id}")
    @Override
    public ApiResponse<Product> update(@RequestBody Product entity, @PathVariable String id) {
        return super.update(entity, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ApiResponse<Void> deleteById(@PathVariable String id) {
        return super.deleteById(id);
    }

    @GetMapping("/checkExistsByIdBrand")
    public ApiResponse<Boolean> checkExistsByIdBrand(@RequestParam String idBrand){
        return ApiResponse.<Boolean>builder()
                .result(productService.existsByIdBrand(idBrand))
                .build();
    }

    @GetMapping("/checkExistsByIdCategory")
    public ApiResponse<Boolean> checkExistsByIdCategory(@RequestParam String idCategory){
        return ApiResponse.<Boolean>builder()
                .result(productService.existsByIdCategory(idCategory))
                .build();
    }

}
