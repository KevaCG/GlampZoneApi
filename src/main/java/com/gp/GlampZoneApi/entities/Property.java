package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProperty;

    @Column (nullable = false)
    private String propertyName;

    @Column (nullable = false)
    private String location;

    @Column (nullable = false)
    private String adress;

    @Column (nullable = false)
    private String description;

    private Boolean status;

    @OneToOne
    @JoinColumn (name = "User")
    private User idUser;

    @OneToMany
    @JoinColumn (name = "Multimedia")
    private List<Multimedia> idMultimedia;

    @OneToMany
    @JoinColumn (name = "Service")
    private List<Service> idService;

    @OneToOne
    @JoinColumn (name = "Category")
    private Category idCategory;

    @OneToMany
    @JoinColumn (name = "Reservation")
    private List<Reservation> idReservation;

    @OneToMany
    @JoinColumn (name = "Comentarys")
    private List<Comentarys> idComentary;
}
