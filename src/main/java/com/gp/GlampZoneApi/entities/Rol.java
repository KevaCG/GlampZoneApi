package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false, unique = true)
    private String rolKey;
}
