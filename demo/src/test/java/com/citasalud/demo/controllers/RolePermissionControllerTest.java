package com.citasalud.demo.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.citasalud.demo.models.Dtos.RoleResponseDto;
import com.citasalud.demo.services.RolePermissionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RolePermissionController.class)
class RolePermissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RolePermissionService rolePermissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenValidRoleId_thenReturnsRolePermissions() throws Exception {
        // Arrange
        Integer roleId = 1;
        List<RoleResponseDto> mockRolePermissions = Arrays.asList(
            new RoleResponseDto("ADMIN", "CREATE_USER"),
            new RoleResponseDto("ADMIN", "DELETE_USER")
        );
        when(rolePermissionService.permisoPorRol(roleId)).thenReturn(mockRolePermissions);

        // Act & Assert
        mockMvc.perform(get("/rol/{idRol}", roleId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(mockRolePermissions)));

        verify(rolePermissionService).permisoPorRol(roleId);
    }

    @Test
    void whenRoleHasNoPermissions_thenReturnsEmptyList() throws Exception {
        // Arrange
        Integer roleId = 2;
        when(rolePermissionService.permisoPorRol(roleId)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/rol/{idRol}", roleId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(rolePermissionService).permisoPorRol(roleId);
    }

    @Test
    void whenInvalidRoleIdFormat_thenReturns400() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/rol/invalid"))
                .andExpect(status().isBadRequest());
    }
}