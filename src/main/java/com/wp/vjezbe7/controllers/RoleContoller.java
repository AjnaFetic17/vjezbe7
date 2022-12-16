package com.wp.vjezbe7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wp.vjezbe7.models.in.RoleIn;
import com.wp.vjezbe7.models.out.RoleOut;
import com.wp.vjezbe7.services.RoleService;

@RestController
@RequestMapping("/api/roles")
@PreAuthorize("hasRole('Admin')")
public class RoleContoller {
  @Autowired
  private RoleService _RoleService;

  @GetMapping(value = "/")
  public List<RoleOut> getAllRoles() {
    return _RoleService.getAll();
  }

  @PostMapping(value = "/")
  public RoleOut addRole(@RequestBody RoleIn roleIn) {
    return _RoleService.save(roleIn);
  }

  @PutMapping(value = "/")
  public RoleOut editRole(@RequestParam("id") String id, @RequestBody RoleIn roleIn) {
    return _RoleService.edit(Integer.parseInt(id), roleIn);
  }

  @DeleteMapping(value = "/")
  public boolean deteleCategory(@RequestParam("id") String id) {
    return _RoleService.delete(Integer.parseInt(id));
  }
}
