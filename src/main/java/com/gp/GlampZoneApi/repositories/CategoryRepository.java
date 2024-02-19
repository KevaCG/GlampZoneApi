package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
