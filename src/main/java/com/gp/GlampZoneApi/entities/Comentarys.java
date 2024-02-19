package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Comentarys {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idComentary;

    @Column(nullable = false)
    private String comentary;

    private LocalDate dateComentary;

    private String picture;

    @ManyToOne
    @JoinColumn (name = "User")
    private User idUser;

    @ManyToOne
    @JoinColumn (name = "Property")
    private Property idProperty;
}
