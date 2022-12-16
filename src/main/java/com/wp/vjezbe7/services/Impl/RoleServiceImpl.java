package com.wp.vjezbe7.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Role;
import com.wp.vjezbe7.models.in.RoleIn;
import com.wp.vjezbe7.models.out.RoleOut;
import com.wp.vjezbe7.repositories.RoleRepository;
import com.wp.vjezbe7.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository _RoleRepository;

  @Override
  public List<RoleOut> getAll() {
    List<Role> roles = _RoleRepository.findAll();
    List<RoleOut> roleOuts = new ArrayList<>();
    for (Role role : roles) {
      roleOuts.add(new RoleOut(role));
    }
    return roleOuts;
  }

  @Override
  public RoleOut save(RoleIn roleIn) {
    Role role = new Role(roleIn);
    _RoleRepository.save(role);
    return new RoleOut(role);
  }

  @Override
  public RoleOut edit(Integer id, RoleIn roleIn) {
    Role role = _RoleRepository.findById(id).get();
    if (role != null) {
      role.setName(roleIn.getName());
      _RoleRepository.save(role);
      return new RoleOut(role);
    }
    return null;
  }

  @Override
  public boolean delete(Integer id) {
    Role role = _RoleRepository.findById(id).get();
    if (role != null) {
      _RoleRepository.delete(role);
      return true;
    }
    return false;
  }

  @Override
  public Role getByName(String name) {
    return _RoleRepository.getByName(name);
  }

  @Override
  public Role getById(Integer id) {
    return _RoleRepository.findById(id).get();
  }
}
