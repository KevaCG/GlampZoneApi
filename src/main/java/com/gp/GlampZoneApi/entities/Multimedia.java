package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMultimedia;

    // Se cambia la ruta de la imagen a un String
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "Property")
    private Property idProperty;
}
