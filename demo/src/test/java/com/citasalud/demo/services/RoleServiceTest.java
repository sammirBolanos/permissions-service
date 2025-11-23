package com.citasalud.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citasalud.demo.models.Dtos.RoleDto;
import com.citasalud.demo.models.OrmModels.Role;
import com.citasalud.demo.repositories.RoleRepository;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void whenGetAllRoles_thenReturnsRoleDtoList() {
        // Arrange
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ADMIN");
        role1.setDescription("Administrador");

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("USER");
        role2.setDescription("Usuario");

        List<Role> mockRoles = Arrays.asList(role1, role2);
        when(roleRepository.findAll()).thenReturn(mockRoles);

        // Act
        List<RoleDto> result = roleService.getAllRoles();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("ADMIN", result.get(0).name());
        assertEquals("USER", result.get(1).name());
        verify(roleRepository).findAll();
    }

    @Test
    void whenNoRoles_thenReturnsEmptyList() {
        // Arrange
        when(roleRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<RoleDto> result = roleService.getAllRoles();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(roleRepository).findAll();
    }
}