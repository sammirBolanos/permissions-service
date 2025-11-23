package com.citasalud.demo.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.citasalud.demo.models.Dtos.RoleDto;
import com.citasalud.demo.services.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RoleController.class)
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenGetAllRoles_thenReturnsRoleList() throws Exception {
        // Arrange
        List<RoleDto> mockRoles = Arrays.asList(
            new RoleDto(1, "ADMIN", "Administrador del sistema"),
            new RoleDto(2, "USER", "Usuario estándar"),
            new RoleDto(3, "COORDINATOR", "Coordinador médico")
        );
        when(roleService.getAllRoles()).thenReturn(mockRoles);

        // Act & Assert
        mockMvc.perform(get("/roles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("ADMIN")))
                .andExpect(jsonPath("$[0].description", is("Administrador del sistema")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("USER")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].name", is("COORDINATOR")));

        verify(roleService).getAllRoles();
    }

    @Test
    void whenNoRolesExist_thenReturnsEmptyList() throws Exception {
        // Arrange
        when(roleService.getAllRoles()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/roles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(content().json("[]"));

        verify(roleService).getAllRoles();
    }

    @Test
    void whenGetAllRoles_thenReturnsSingleRole() throws Exception {
        // Arrange
        List<RoleDto> mockRoles = Arrays.asList(
            new RoleDto(1, "ADMIN", "Administrador del sistema")
        );
        when(roleService.getAllRoles()).thenReturn(mockRoles);

        // Act & Assert
        mockMvc.perform(get("/roles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("ADMIN")));

        verify(roleService).getAllRoles();
    }
}