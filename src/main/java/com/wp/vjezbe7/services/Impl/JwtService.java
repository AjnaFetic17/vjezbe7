package com.wp.vjezbe7.services.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.User;
import com.wp.vjezbe7.models.helpers.JwtRequest;
import com.wp.vjezbe7.models.helpers.JwtResponse;
import com.wp.vjezbe7.models.helpers.JwtUtil;
import com.wp.vjezbe7.repositories.UserRepository;

@Service
public class JwtService implements UserDetailsService {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private UserRepository _UserRepository;

  @Autowired
  @Lazy
  private AuthenticationManager authenticationManager;

  public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
    String email = jwtRequest.getEmail();
    String userPassword = jwtRequest.getPassword();
    authenticate(email, userPassword);

    UserDetails userDetails = loadUserByUsername(email);
    String newGeneratedToken = jwtUtil.generateToken(userDetails);

    JwtResponse aaa = new JwtResponse(newGeneratedToken);
    return aaa;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = _UserRepository.getByEmail(username);

    if (user != null) {
      return new org.springframework.security.core.userdetails.User(
          user.getEmail(),
          user.getPassword(),
          getAuthority(user));
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }

  private Set getAuthority(User user) {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

    return authorities;
  }

  private void authenticate(String userName, String userPassword) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }

}
