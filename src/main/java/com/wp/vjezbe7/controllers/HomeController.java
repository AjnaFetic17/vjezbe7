package com.wp.vjezbe7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wp.vjezbe7.models.helpers.JwtRequest;
import com.wp.vjezbe7.models.helpers.JwtResponse;
import com.wp.vjezbe7.services.Impl.JwtService;

@RestController
@CrossOrigin
public class HomeController {

  @Autowired
  private JwtService _JwtService;

  @GetMapping("/")
  public String hi() {
    return "Hello world.";
  }

  @PostMapping("/login")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    return _JwtService.createJwtToken(jwtRequest);
  }
}
