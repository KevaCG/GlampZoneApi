package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column (nullable = false, unique = true)
    private String categoryName;
}
