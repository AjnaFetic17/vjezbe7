package com.wp.vjezbe7.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Role;
import com.wp.vjezbe7.models.entities.User;
import com.wp.vjezbe7.models.in.UserIn;
import com.wp.vjezbe7.models.out.UserOut;
import com.wp.vjezbe7.repositories.UserRepository;
import com.wp.vjezbe7.services.RoleService;
import com.wp.vjezbe7.services.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository _UserRepository;

  @Autowired
  private RoleService _RoleService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<UserOut> getAll() {
    List<User> users = _UserRepository.findAll();
    List<UserOut> userOuts = new ArrayList<>();

    for (User user : users) {
      userOuts.add(new UserOut(user));
    }
    return userOuts;
  }

  @Override
  public UserOut save(UserIn userIn) {
    User user = new User(userIn);

    Role role = _RoleService.getByName("user");
    if (role != null) {
      user.setEmail(userIn.getEmail());
      user.setPassword(getEncodedPassword(userIn.getPassword()));
      user.setRole(role);
      _UserRepository.save(user);
      return new UserOut(user);
    }
    return null;
  }

  @Override
  public UserOut edit(Integer id, UserIn userIn) {
    User user = _UserRepository.findById(id).get();
    if (user != null) {
      user.setEmail(userIn.getEmail());
      Role role = _RoleService.getById(userIn.getRoleId());
      user.setRole(role);
      _UserRepository.save(user);
      return new UserOut(user);
    }
    return null;
  }

  @Override
  public boolean delete(Integer id) {
    User user = _UserRepository.findById(id).get();
    if (user != null) {
      _UserRepository.delete(user);
      return true;
    }
    return false;
  }

  public String getEncodedPassword(String password) {
    return passwordEncoder.encode(password);
  }

  @Override
  public User getByEmail(String email) {
    return _UserRepository.getByEmail(email);
  }
}
