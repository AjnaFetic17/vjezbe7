package com.wp.vjezbe7.models.in;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

public class UserIn {
  @Nullable
  private Integer id;

  @Size(max = 255)
  private String email;

  private String password;

  @Nullable
  private Integer roleId;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

}
