package com.book.bookapplication.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig{
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwrff0el0",
                "api_key", "851462578421834",
                "api_secret", "9ARcn7DGpKWTBHGbzjMMsbuzrS4"));
    }
}