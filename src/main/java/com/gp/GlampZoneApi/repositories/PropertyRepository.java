package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
