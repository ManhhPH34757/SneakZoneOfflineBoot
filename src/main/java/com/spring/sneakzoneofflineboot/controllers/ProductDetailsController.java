package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.entities.ProductDetail;
import com.spring.sneakzoneofflineboot.services.ProductDetailsService;
import com.spring.sneakzoneofflineboot.utils.UtilityController;
import com.spring.sneakzoneofflineboot.utils.UtilityServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-details")
public class ProductDetailsController extends UtilityController<ProductDetail, String> {
    private final ProductDetailsService productDetailsService;

    public ProductDetailsController(UtilityServices<ProductDetail, String> utilityServices, ProductDetailsService productDetailsService) {
        super(utilityServices);
        this.productDetailsService = productDetailsService;
    }

    @GetMapping("/{idProduct}")
    public ApiResponse<List<ProductDetail>> getAllByIdProduct(@PathVariable String idProduct) {
        return ApiResponse.<List<ProductDetail>>builder()
               .result(productDetailsService.getProductDetailsByIdProduct(idProduct))
               .build();
    }

    @PostMapping("/{idProduct}")
    @Override
    public ApiResponse<ProductDetail> save(@RequestBody ProductDetail entity) {
        return super.save(entity);
    }

    @GetMapping("/{idProduct}/check")
    public ApiResponse<Boolean> checkExists(@RequestParam @PathVariable String idProduct, @RequestParam String idColor, @RequestParam String idSize) {
        return ApiResponse.<Boolean>builder()
               .result(productDetailsService.getByIdProductAndColorAndSize(idProduct, idColor, idSize))
               .build();
    }

    @PutMapping("/{idProduct}/{id}")
    public ApiResponse<ProductDetail> update(@RequestBody ProductDetail productDetail, @PathVariable String idProduct, @PathVariable String id) {
        return ApiResponse.<ProductDetail>builder()
                .result(productDetailsService.update(productDetail, id))
                .build();
    }

    @GetMapping("/exists-products")
    public ApiResponse<Boolean> checkExistsProduct(@RequestParam String idProduct) {
        return ApiResponse.<Boolean>builder()
               .result(productDetailsService.getByIdProduct(idProduct))
               .build();
    }
}
