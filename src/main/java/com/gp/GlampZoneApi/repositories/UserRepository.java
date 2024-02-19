package com.gp.GlampZoneApi.repositories;

import com.gp.GlampZoneApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Consultar usuarios por ID
    @Query("SELECT us FROM User us WHERE us.idUser = :idUser")
    public User findByUserDni(@Param("idUser") Long idUser);

    // Consultar usuarios por Email
    @Query("SELECT us FROM User us WHERE us.email = :email")
    public User findByUserEmail(@Param("email") String email);

    // Consultar usuarios por Nombre y Apellido
    @Query("SELECT us FROM User us WHERE us.firstName = :firstName")
    public List<User> findByUserFirstName(@Param("firstName") String firstName);

    @Query("SELECT us FROM User us WHERE us.lastName = :lastName")
    public List<User> findByUserLastName(@Param("lastName") String lastName);
}
