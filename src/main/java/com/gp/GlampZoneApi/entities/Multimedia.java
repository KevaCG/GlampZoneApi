package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Multimedia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idMultimedia;

    @Column(nullable = false)
    private String picture;

    @ManyToOne
    @JoinColumn (name = "Property")
    private Property idProperty;
}
