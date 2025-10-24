package com.citasalud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasalud.demo.models.OrmModels.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {}
