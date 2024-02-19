package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.Rol;
import com.gp.GlampZoneApi.repositories.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    @Transactional
    public void postRol(Long idRol, String rolKey){


        Rol rol = new Rol();

        rol.setIdRol(idRol);
        rol.setRolKey(rolKey);

        rolRepository.save(rol);
    }

    public List<Rol> getAllRoles(){
        return rolRepository.findAll();
    }

    public Optional<Rol> getRol(Long idRol){
        return rolRepository.findById(idRol);
    }

    @Transactional
    public void putRol(Long idRol, String rolKey){

        Optional<Rol> response =rolRepository.findById(idRol);

        if (response.isPresent()){

            Rol rol = response.get();

            rol.setRolKey(rolKey);

            rolRepository.save(rol);
        }
    }

    public void deleteRol(Long idRol){
        rolRepository.deleteById(idRol);
    }


}
