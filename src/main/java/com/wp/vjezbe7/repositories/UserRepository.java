package com.wp.vjezbe7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wp.vjezbe7.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public User getByEmail(String email);
}
