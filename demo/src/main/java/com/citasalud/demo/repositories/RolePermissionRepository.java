package com.citasalud.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasalud.demo.models.OrmModels.RolePermission;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    @EntityGraph(attributePaths = {"role", "permission"})
    List<RolePermission> findByRole_Id(Integer id);
}
