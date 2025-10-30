package com.citasalud.demo.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citasalud.demo.models.Dtos.RoleResponseDto;
import com.citasalud.demo.models.OrmModels.Permission;
import com.citasalud.demo.models.OrmModels.Role;
import com.citasalud.demo.models.OrmModels.RolePermission;
import com.citasalud.demo.repositories.RolePermissionRepository;

@ExtendWith(MockitoExtension.class)
class RolePermissionServiceTest {

    @Mock
    private RolePermissionRepository rolePermissionRepository;

    @InjectMocks
    private RolePermissionService rolePermissionService;

    @Test
    void whenGetPermisoPorRol_withValidId_thenReturnsListOfPermissions() {
        // Arrange
        Integer roleId = 1;
        Role role = new Role();
        role.setId(roleId);
        role.setName("ADMIN");

        Permission permission1 = new Permission();
        permission1.setId(1);
        permission1.setName("CREATE_USER");

        Permission permission2 = new Permission();
        permission2.setId(2);
        permission2.setName("DELETE_USER");

        RolePermission rp1 = new RolePermission();
        rp1.setId(1);
        rp1.setRole(role);
        rp1.setPermission(permission1);

        RolePermission rp2 = new RolePermission();
        rp2.setId(2);
        rp2.setRole(role);
        rp2.setPermission(permission2);

        List<RolePermission> rolePermissions = Arrays.asList(rp1, rp2);
        when(rolePermissionRepository.findByRole_Id(roleId)).thenReturn(rolePermissions);

        // Act
        List<RoleResponseDto> result = rolePermissionService.permisoPorRol(roleId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("ADMIN", result.get(0).roleName());
        assertEquals("CREATE_USER", result.get(0).rolePermission());
        assertEquals("ADMIN", result.get(1).roleName());
        assertEquals("DELETE_USER", result.get(1).rolePermission());
        verify(rolePermissionRepository).findByRole_Id(roleId);
    }

    @Test
    void whenGetPermisoPorRol_withNoPermissions_thenReturnsEmptyList() {
        // Arrange
        Integer roleId = 999;
        when(rolePermissionRepository.findByRole_Id(roleId)).thenReturn(Collections.emptyList());

        // Act
        List<RoleResponseDto> result = rolePermissionService.permisoPorRol(roleId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(rolePermissionRepository).findByRole_Id(roleId);
    }

    @Test
    void whenGetPermisoPorRol_withSinglePermission_thenReturnsListWithOneElement() {
        // Arrange
        Integer roleId = 2;
        Role role = new Role();
        role.setId(roleId);
        role.setName("USER");

        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("READ_ONLY");

        RolePermission rp = new RolePermission();
        rp.setId(1);
        rp.setRole(role);
        rp.setPermission(permission);

        when(rolePermissionRepository.findByRole_Id(roleId)).thenReturn(Collections.singletonList(rp));

        // Act
        List<RoleResponseDto> result = rolePermissionService.permisoPorRol(roleId);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("USER", result.get(0).roleName());
        assertEquals("READ_ONLY", result.get(0).rolePermission());
        verify(rolePermissionRepository).findByRole_Id(roleId);
    }
}
