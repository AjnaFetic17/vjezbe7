package com.wp.vjezbe7.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Role;
import com.wp.vjezbe7.models.in.RoleIn;
import com.wp.vjezbe7.models.out.RoleOut;

@Service
public interface RoleService {
  List<RoleOut> getAll();

  RoleOut save(RoleIn roleIn);

  RoleOut edit(Integer id, RoleIn roleIn);

  boolean delete(Integer id);

  Role getByName(String name);

  Role getById(Integer id);

}
