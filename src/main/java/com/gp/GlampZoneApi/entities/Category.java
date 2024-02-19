package com.gp.GlampZoneApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDate.now();
    }

    public Category() {
        this.createdDate = LocalDate.now();
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.createdDate = LocalDate.now();
    }
}
