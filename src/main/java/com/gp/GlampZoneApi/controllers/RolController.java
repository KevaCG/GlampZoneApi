package com.gp.GlampZoneApi.controllers;

import com.gp.GlampZoneApi.entities.Rol;
import com.gp.GlampZoneApi.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rol")


public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/roles")
    public List<Rol> getAllRolesController(){
        return rolService.getAllRoles();
    }

    public Optional<Rol> getRolController(@PathVariable("idRol") Long idRol){
        return rolService.getRol(idRol);
    }

    public Rol postRolController(@RequestBody Rol rol){
        rolService.postRol(rol);

        return rol;
    }
}
