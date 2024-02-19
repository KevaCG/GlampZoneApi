package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.Rol;
import com.gp.GlampZoneApi.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public ArrayList<Rol> getAllRoles(){
        return (ArrayList<Rol>) rolRepository.findAll();
    }

    public Optional<Rol> getRol(Long id){
        return rolRepository.findById(id);
    }

    public Rol postRol(Rol rol){
        return rolRepository.save(rol);
    }

    public Rol putRol(Rol request, Long id){
        Rol rol = rolRepository.findById(id).get();

        rol.setRolName(request.getRolName());

        return rol;
    }

    public Boolean deleteRol(Long id){
        try {
            rolRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
