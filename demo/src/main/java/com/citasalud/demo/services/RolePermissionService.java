package com.citasalud.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citasalud.demo.models.Dtos.RoleResponseDto;
import com.citasalud.demo.models.OrmModels.RolePermission;
import com.citasalud.demo.repositories.RolePermissionRepository;

@Service
public class RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionService(
        RolePermissionRepository rolePermissionRepository
        ) {
        this.rolePermissionRepository = rolePermissionRepository;
    }
    private RoleResponseDto mapToDto(RolePermission rolePermission) {
        return new RoleResponseDto(
            rolePermission.getRole().getName(),
            rolePermission.getPermission().getName()
        );
    }

    public List<RoleResponseDto> permisoPorRol (Integer idRol) {
        return rolePermissionRepository.findByRole_Id(idRol)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

}
