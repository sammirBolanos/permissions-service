package com.citasalud.demo.models.OrmModels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PermissionTest {

    @Test
    void whenCreatePermission_thenGettersWork() {
        // Arrange & Act
        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("CREATE_USER");
        permission.setDescription("Permission to create users");

        // Assert
        assertNotNull(permission);
        assertEquals(1, permission.getId());
        assertEquals("CREATE_USER", permission.getName());
        assertEquals("Permission to create users", permission.getDescription());
    }

    @Test
    void whenCreatePermission_withNullDescription_thenDescriptionIsNull() {
        // Arrange & Act
        Permission permission = new Permission();
        permission.setId(2);
        permission.setName("READ_USER");

        // Assert
        assertEquals(2, permission.getId());
        assertEquals("READ_USER", permission.getName());
        assertNull(permission.getDescription());
    }

    @Test
    void whenSetAllFields_thenAllFieldsAreSet() {
        // Arrange
        Permission permission = new Permission();

        // Act
        permission.setId(3);
        permission.setName("DELETE_USER");
        permission.setDescription("Permission to delete users from the system");

        // Assert
        assertEquals(3, permission.getId());
        assertEquals("DELETE_USER", permission.getName());
        assertEquals("Permission to delete users from the system", permission.getDescription());
    }
}
