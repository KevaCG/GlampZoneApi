package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;

    @Column(unique = true, nullable = false)
    private String serviceName;

    @ManyToOne
    @JoinColumn (name = "Property")
    private Property idProperty;
}
