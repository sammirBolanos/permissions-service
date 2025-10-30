package com.citasalud.demo.models.OrmModels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class RoleTest {

    @Test
    void whenCreateRole_thenGettersWork() {
        // Arrange & Act
        Role role = new Role();
        role.setId(1);
        role.setName("ADMIN");
        role.setDescription("Administrator role");

        // Assert
        assertNotNull(role);
        assertEquals(1, role.getId());
        assertEquals("ADMIN", role.getName());
        assertEquals("Administrator role", role.getDescription());
    }

    @Test
    void whenCreateRole_withNullDescription_thenDescriptionIsNull() {
        // Arrange & Act
        Role role = new Role();
        role.setId(2);
        role.setName("USER");

        // Assert
        assertEquals(2, role.getId());
        assertEquals("USER", role.getName());
        assertNull(role.getDescription());
    }

    @Test
    void whenSetAllFields_thenAllFieldsAreSet() {
        // Arrange
        Role role = new Role();

        // Act
        role.setId(3);
        role.setName("MODERATOR");
        role.setDescription("Moderator role with limited permissions");

        // Assert
        assertEquals(3, role.getId());
        assertEquals("MODERATOR", role.getName());
        assertEquals("Moderator role with limited permissions", role.getDescription());
    }
}
