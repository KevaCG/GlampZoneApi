package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cellPhone;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Temporal(TemporalType.DATE)
    private LocalDate registerDate;

    private String profilePicture;

    @Column(nullable = false)
    private String location;

    private boolean status;


    public User() {
        this.registerDate = LocalDate.now();
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registerDate = LocalDate.now();
    }


}
