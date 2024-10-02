package com.spring.sneakzoneofflineboot.utils;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class UtilityController <E, T>{
     UtilityServices<E, T> utilityServices;

     public ApiResponse<List<E>> getAll() {
          return ApiResponse.<List<E>>builder()
               .result(utilityServices.getAll())
               .build();
     }

     public ApiResponse<E> getById(T id) {
          return ApiResponse.<E>builder()
               .result(utilityServices.getById(id))
               .build();
     }

     public ApiResponse<E> save(E entity) {
          return ApiResponse.<E>builder()
               .result(utilityServices.save(entity))
               .build();
     }

     public ApiResponse<E> update(E entity, T id) {
          return ApiResponse.<E>builder()
               .result(utilityServices.update(entity, id))
               .build();
     }

     public ApiResponse<Void> deleteById(T id) {
          utilityServices.deleteById(id);
          return ApiResponse.<Void>builder()
               .result(null)
               .build();
     }
}
