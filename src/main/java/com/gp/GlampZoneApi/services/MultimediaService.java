package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.Multimedia;
import com.gp.GlampZoneApi.repositories.MultimediaRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MultimediaService {

    @Autowired
    private MultimediaRepository multimediaRepository;

    private final String UPLOAD_DIRECTORY = "/uploads";

    // Obtener una imagen por ID
    public Optional<Multimedia> getImage(Long id) {
        return multimediaRepository.findById(id);
    }

    // Obtener todas las imágenes
    public List<Multimedia> getImages() {
        return multimediaRepository.findAll();
    }

    // Guardar una imagen (recibe la imagen como MultipartFile)
    public Multimedia postImage(MultipartFile image) throws IOException {
        String filename = generateUniqueFilename(image.getOriginalFilename());
        String filePath = UPLOAD_DIRECTORY + "/" + filename;
        File file = new File(filePath);

        // Guardar la imagen en el servidor
        image.transferTo(file);

        Multimedia multimedia = new Multimedia();
        multimedia.setImageUrl(filePath);
        return multimediaRepository.save(multimedia);
    }

    // Actualizar una imagen (recibe la imagen como MultipartFile y el ID)
    public Multimedia putImage(Long id, MultipartFile image) throws IOException {
        Optional<Multimedia> multimediaOptional = multimediaRepository.findById(id);
        if (multimediaOptional.isPresent()) {
            Multimedia multimedia = multimediaOptional.get();

            String filePath = multimedia.getImageUrl();
            File file = new File(filePath);

            // Eliminar la imagen anterior
            file.delete();

            String filename = generateUniqueFilename(image.getOriginalFilename());
            filePath = UPLOAD_DIRECTORY + "/" + filename;
            file = new File(filePath);

            // Guardar la nueva imagen en el servidor
            image.transferTo(file);

            multimedia.setImageUrl(filePath);
            return multimediaRepository.save(multimedia);
        } else {
            throw new RuntimeException("Imagen no encontrada");
        }
    }

    // Eliminar una imagen por ID
    public void deleteImage(Long id) {
        Optional<Multimedia> multimediaOptional = multimediaRepository.findById(id);
        if (multimediaOptional.isPresent()) {
            Multimedia multimedia = multimediaOptional.get();

            String filePath = multimedia.getImageUrl();
            File file = new File(filePath);

            // Eliminar la imagen del servidor
            file.delete();

            multimediaRepository.deleteById(id);
        }
    }

    private String generateUniqueFilename(String filename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return timestamp + "_" + filename;
    }
}
