package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    private Long idUser;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column (nullable = false)
    private Integer numberPhone;

    @Column (unique = true, nullable = false)
    private String email;

    @Column (nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Temporal(TemporalType.DATE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDate registerDate;

    // private String profilePicture;

    @Column (nullable = false)
    private String location;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "Rol")
    private Rol rol;
}
