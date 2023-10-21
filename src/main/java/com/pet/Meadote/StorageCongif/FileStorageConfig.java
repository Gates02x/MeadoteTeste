package com.pet.Meadote.StorageCongif;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileStorageConfig {

    public void saveImage(String imageName, MultipartFile imageFile) {
        try {
            String uploadDir = System.getProperty("user.dir") + File.separator + "imagens";

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(directory, imageName);
            imageFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao salvar a imagem.", e);
        }
    }

    public UrlResource loadImageAsResource(String imageName) throws MalformedURLException {
        String uploadDir = System.getProperty("user.dir") + File.separator + "imagens";
        Path imagePath = Paths.get(uploadDir).resolve(imageName).normalize();
        UrlResource resource = new UrlResource(imagePath.toUri());
        return resource;
    }
}