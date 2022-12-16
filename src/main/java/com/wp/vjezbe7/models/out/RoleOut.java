package com.wp.vjezbe7.models.out;

import com.wp.vjezbe7.models.entities.Role;

public class RoleOut {

  private Integer id;

  private String name;

  public RoleOut(Role role) {
    id = role.getId();
    name = role.getName();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
