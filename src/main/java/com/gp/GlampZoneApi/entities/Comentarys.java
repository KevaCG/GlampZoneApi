package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Comentarys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentary;

    @Column(nullable = false)
    private String commentary;

    @Temporal(TemporalType.DATE)
    private LocalDate dateComentary;

    private String picture;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idProperty")
    private Property idProperty;


    @PrePersist
    public void prePersist() {
        dateComentary = LocalDate.now();
    }

    public Comentarys(String commentary, User idUser, Property idProperty) {
        this.commentary = commentary;
        this.idUser = idUser;
        this.idProperty = idProperty;
        this.dateComentary = LocalDate.now();
    }
}
