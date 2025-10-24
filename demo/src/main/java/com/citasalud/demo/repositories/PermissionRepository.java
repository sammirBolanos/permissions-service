package com.citasalud.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasalud.demo.models.OrmModels.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {}
