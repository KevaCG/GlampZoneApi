package com.gp.GlampZoneApi.controllers;

import com.gp.GlampZoneApi.entities.Multimedia;
import com.gp.GlampZoneApi.entities.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/multimedia")
public class MultimediaController {

    @Autowired
    private MultimediaService multimediaService;

    // Obtener una imagen por ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Long id) throws IOException {
        Optional<Multimedia> multimedia = multimediaService.getImage(id);
        if (multimedia.isPresent()) {
            String filePath = multimedia.get().getImageUrl();
            File file = new File(filePath);
            Resource resource = new FileSystemResource(file);
            return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.parseMediaType(URLConnection.guessContentTypeFromName(file.getName()))).body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todas las imágenes
    @GetMapping("/")
    public List<Multimedia> getImages() {
        return multimediaService.getImages();
    }

    // Guardar una imagen (recibe la imagen como MultipartFile en el cuerpo)
    @PostMapping("/")
    public Multimedia postImage(@RequestParam("image") MultipartFile image) throws IOException {
        return multimediaService.postImage(image);
    }

    // Actualizar una imagen (recibe la imagen como MultipartFile y el ID en el cuerpo)
    @PutMapping("/{id}")
    public Multimedia putImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) throws IOException {
        return multimediaService.putImage(id, image);
    }

    // Eliminar una imagen por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        multimediaService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
