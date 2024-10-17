package com.spring.sneakzoneofflineboot.controllers;

import com.spring.sneakzoneofflineboot.dto.response.ApiResponse;
import com.spring.sneakzoneofflineboot.services.CloudinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final CloudinaryService cloudinaryService;

    public ImageController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ApiResponse<List<Map<String, String>>> uploadImages(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<Map<String, String>> responses = new ArrayList<>();
        for (MultipartFile file : files) {
            String url = cloudinaryService.uploadImage(file);
            Map<String, String> response = new HashMap<>();
            response.put("secure_url", url);
            responses.add(response);
        }
        return ApiResponse.<List<Map<String, String>>>builder()
                .result(responses)
                .build();
    }

    @GetMapping("/list")
    public ApiResponse<List<Map>> listImages() {
        try {
            List<Map> images = cloudinaryService.listImages();
            return ApiResponse.<List<Map>>builder()
                    .result(images)
                    .build();
        } catch (Exception e) {
            return ApiResponse.<List<Map>>builder()
                    .result(null)
                    .message("No images")
                    .build();
        }
    }


}
