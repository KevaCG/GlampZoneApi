package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Buscar por el ID del servicio
    @Query("SELECT se FROM Service se WHERE se.idService = :idService")
    public Service findByServices(@Param("idService") Long idService);

    // Buscar por el Nombre del servicio
    @Query("SELECT se FROM Service se WHERE se.serviceName = :serviceName")
    public Service findByServicesName(@Param("serviceName") String serviceName);
}
