package com.citasalud.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citasalud.demo.models.Dtos.RoleDto;
import com.citasalud.demo.models.OrmModels.Role;
import com.citasalud.demo.repositories.RoleRepository;

@Service
public class RoleService {
    
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Método helper para mapear Role a RoleDto
    private RoleDto mapToDto(Role role) {
        return new RoleDto(
            role.getId(),
            role.getName(),
            role.getDescription()
        );
    }

    // Método que obtiene todos los roles
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }
}