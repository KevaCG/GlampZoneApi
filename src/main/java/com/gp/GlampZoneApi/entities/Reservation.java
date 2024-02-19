package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column (nullable = false)
    private Date initialDate;

    @Column (nullable = false)
    private Date finalDate;

    @Column (nullable = false)
    private String priece;

    @ManyToOne
    @JoinColumn (name = "User")
    private User idUser;

    @ManyToOne
    @JoinColumn (name = "Property")
    private Property idProperty;
}
