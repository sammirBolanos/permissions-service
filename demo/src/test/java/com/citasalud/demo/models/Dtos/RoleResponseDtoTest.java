package com.citasalud.demo.models.Dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class RoleResponseDtoTest {

    @Test
    void whenCreateRoleResponseDto_thenFieldsAreSet() {
        // Arrange & Act
        RoleResponseDto dto = new RoleResponseDto("ADMIN", "CREATE_USER");

        // Assert
        assertNotNull(dto);
        assertEquals("ADMIN", dto.roleName());
        assertEquals("CREATE_USER", dto.rolePermission());
    }

    @Test
    void whenCreateMultipleDtos_thenEachHasDifferentValues() {
        // Arrange & Act
        RoleResponseDto dto1 = new RoleResponseDto("ADMIN", "CREATE_USER");
        RoleResponseDto dto2 = new RoleResponseDto("USER", "READ_DATA");

        // Assert
        assertEquals("ADMIN", dto1.roleName());
        assertEquals("CREATE_USER", dto1.rolePermission());
        assertEquals("USER", dto2.roleName());
        assertEquals("READ_DATA", dto2.rolePermission());
    }

    @Test
    void whenCreateDtoWithLongNames_thenValuesArePreserved() {
        // Arrange
        String longRoleName = "SUPER_ADMINISTRATOR_WITH_FULL_ACCESS";
        String longPermissionName = "DELETE_ALL_USERS_AND_DATA_PERMANENTLY";

        // Act
        RoleResponseDto dto = new RoleResponseDto(longRoleName, longPermissionName);

        // Assert
        assertEquals(longRoleName, dto.roleName());
        assertEquals(longPermissionName, dto.rolePermission());
    }
}
