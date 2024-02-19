package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolRepository extends JpaRepository<Rol, Long> {
    // Buscar por el ID del Rol
    @Query("SELECT rol FROM Rol rol WHERE rol.idRol = :idRol")
    public Rol findByIdRol(@Param("idRol") Long idRol);

    // Buscar por el Nombre del Rol
    @Query("SELECT rol FROM Rol rol WHERE rol.idRol = :idRol")
    public Rol findByRolName(@Param("idRol") String idRol);
}
