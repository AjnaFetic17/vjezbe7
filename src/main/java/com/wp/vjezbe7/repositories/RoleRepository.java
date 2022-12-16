package com.wp.vjezbe7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wp.vjezbe7.models.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

  public Role getByName(String name);
}
