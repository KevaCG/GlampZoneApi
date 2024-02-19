package com.gp.GlampZoneApi.controllers;

import com.gp.GlampZoneApi.entities.Rol;
import com.gp.GlampZoneApi.services.RolService;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public ArrayList<Rol> getAllRolesController(){
        return this.rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Rol> getRolController(@PathVariable Long id){
        return this.rolService.getRol(id);
    }

    @PostMapping("/")
    public Rol postRolController(@RequestBody Rol rol){
        return this.rolService.postRol(rol);
    }

    @PutMapping("/{id}")
    public Rol putRolController(@RequestBody Rol rol, @PathVariable("id")Long id){
        return this.rolService.putRol(rol, id);
    }

    @DeleteMapping("/{id}")
    public String deleteRolController(@PathVariable("id") Long id){
        boolean ok = this.rolService.deleteRol(id);

        if (ok){
            return "Rol id"+id+" Elimnado";
        }else{
            return  "Rol id"+id+" No eliminado";
        }
    }
}
