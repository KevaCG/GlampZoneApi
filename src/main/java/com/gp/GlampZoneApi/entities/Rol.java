package com.gp.GlampZoneApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rol {
    @Id
    private Long id;

    @Column(nullable = false)
    private String rolName;
}
