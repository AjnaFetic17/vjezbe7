package com.wp.vjezbe7.models.helpers;

public class JwtResponse {
  private String accessToken;

  public JwtResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getJwtToken() {
    return accessToken;
  }

  public void setJwtToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
