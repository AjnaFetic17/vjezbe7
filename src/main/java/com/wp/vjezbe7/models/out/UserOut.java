package com.wp.vjezbe7.models.out;

import com.wp.vjezbe7.models.entities.User;

public class UserOut {

  private Integer id;

  private String email;

  private String role;

  public UserOut(User user) {
    id = user.getId();
    email = user.getEmail();
    role = user.getRole().getName();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
