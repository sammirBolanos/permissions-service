package com.citasalud.demo.models.OrmModels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class RolePermissionTest {

    @Test
    void whenCreateRolePermission_thenGettersWork() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("ADMIN");

        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("CREATE_USER");

        // Act
        RolePermission rolePermission = new RolePermission();
        rolePermission.setId(1);
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);

        // Assert
        assertNotNull(rolePermission);
        assertEquals(1, rolePermission.getId());
        assertNotNull(rolePermission.getRole());
        assertEquals("ADMIN", rolePermission.getRole().getName());
        assertNotNull(rolePermission.getPermission());
        assertEquals("CREATE_USER", rolePermission.getPermission().getName());
    }

    @Test
    void whenSetAllFields_thenAllFieldsAreSet() {
        // Arrange
        Role role = new Role();
        role.setId(2);
        role.setName("USER");

        Permission permission = new Permission();
        permission.setId(2);
        permission.setName("READ_DATA");

        RolePermission rolePermission = new RolePermission();

        // Act
        rolePermission.setId(5);
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);

        // Assert
        assertEquals(5, rolePermission.getId());
        assertEquals(2, rolePermission.getRole().getId());
        assertEquals("USER", rolePermission.getRole().getName());
        assertEquals(2, rolePermission.getPermission().getId());
        assertEquals("READ_DATA", rolePermission.getPermission().getName());
    }

    @Test
    void whenCreateMultipleRolePermissions_thenEachHasUniqueId() {
        // Arrange
        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setName("ADMIN");

        Permission createPerm = new Permission();
        createPerm.setId(1);
        createPerm.setName("CREATE");

        Permission deletePerm = new Permission();
        deletePerm.setId(2);
        deletePerm.setName("DELETE");

        // Act
        RolePermission rp1 = new RolePermission();
        rp1.setId(1);
        rp1.setRole(adminRole);
        rp1.setPermission(createPerm);

        RolePermission rp2 = new RolePermission();
        rp2.setId(2);
        rp2.setRole(adminRole);
        rp2.setPermission(deletePerm);

        // Assert
        assertEquals(1, rp1.getId());
        assertEquals(2, rp2.getId());
        assertEquals("ADMIN", rp1.getRole().getName());
        assertEquals("ADMIN", rp2.getRole().getName());
        assertEquals("CREATE", rp1.getPermission().getName());
        assertEquals("DELETE", rp2.getPermission().getName());
    }
}
