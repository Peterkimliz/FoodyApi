package com.foody.foody.Services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${file.upload-dir}")
    String uploadDirectory;

    public String storeFile(MultipartFile file) {
        Path uploadPath = Paths.get(uploadDirectory);

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String uniqueFileName = UUID.randomUUID() + "_" + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Path targetLocation = uploadPath.resolve(uniqueFileName);
            System.out.println("Path is " + targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return uniqueFileName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public Resource loadFileAsResource(String fileName) {
            try {
                Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
                Resource resource = new UrlResource(filePath.toUri());

                if (resource.exists()) {
                    return resource;
                } else {
                    throw new RuntimeException("File not found " + fileName);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("File not found " + fileName, e);
            }
        }
    }

