package com.wp.vjezbe7.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.User;
import com.wp.vjezbe7.models.in.UserIn;
import com.wp.vjezbe7.models.out.UserOut;

@Service
public interface UserService {

  List<UserOut> getAll();

  UserOut save(UserIn userIn);

  UserOut edit(Integer id, UserIn userIn);

  boolean delete(Integer id);

  User getByEmail(String email);
}
