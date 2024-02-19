package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
