package com.citasalud.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citasalud.demo.models.Dtos.RoleResponseDto;
import com.citasalud.demo.services.RolePermissionService;

@RestController
public class RolePermissionController {
    private final RolePermissionService rolePermissionService;

    
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }
    @GetMapping("/rol/{idRol}")
    public ResponseEntity<List<RoleResponseDto>> obtenerPorRol(@PathVariable Integer idRol) {
        return ResponseEntity.ok(rolePermissionService.permisoPorRol(idRol));
    }

}
