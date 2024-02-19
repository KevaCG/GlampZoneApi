package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    private Long idUser;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash; // Almacenar contraseña encriptada

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Temporal(TemporalType.DATE)
    private LocalDate registerDate;

    // private String profilePicture;

    @Column(nullable = false)
    private String location;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    public User() {
        this.registerDate = LocalDate.now();
    }

    public User(String firstName, String lastName, String email, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerDate = LocalDate.now();
    }


}
