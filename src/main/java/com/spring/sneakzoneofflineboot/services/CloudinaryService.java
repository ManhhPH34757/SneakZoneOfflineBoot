package com.spring.sneakzoneofflineboot.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryService {

    Cloudinary cloudinary;

    public String uploadImage(MultipartFile file) throws IOException {
        String publicId = file.getOriginalFilename();
        @SuppressWarnings("unchecked")
        Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", publicId));
        return (String) uploadResult.get("secure_url");
    }

    public List<Map> listImages() throws Exception {
        List<Map> allImages = new ArrayList<>();
        String nextCursor = null;

        do {
            Map<String, Object> options = ObjectUtils.asMap(
                    "max_results", 500,
                    "next_cursor", nextCursor
            );

            Map<String, Object> result = cloudinary.api().resources(options);
            List<Map> resources = (List<Map>) result.get("resources");

            allImages.addAll(resources);

            nextCursor = (String) result.get("next_cursor");

        } while (nextCursor != null);

        return allImages;
    }

}
