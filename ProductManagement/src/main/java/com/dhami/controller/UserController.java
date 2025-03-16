package com.dhami.controller;

import com.dhami.dto.UserDTO;
import com.dhami.dto.UserResponseDTO;
import com.dhami.entity.User;
import com.dhami.security.JwtUtil;
import com.dhami.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Assign ROLE_USER to all new users
        user.setRole("USER");
        return myUserDetailsService.createUser(user);
    }

    @PostMapping("/register-admin")
    public User registerAdmin(@RequestBody User user) {
        // Assign ROLE_ADMIN to this user
        user.setRole("ADMIN");
        return myUserDetailsService.createUser(user);
    }
   @PostMapping(value = "/login",consumes = "application/json",produces = "application/json")
    public UserResponseDTO login(@RequestBody UserDTO userDTO){
    // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Fetch user roles
   List<String> roles =  authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority).toList();

    // Load user details and generate token
   UserDetails userDetails = myUserDetailsService.loadUserByUsername(userDTO.getUsername());
   String token = jwtUtil.generateToken(userDetails.getUsername(), roles);
    UserResponseDTO userResponseDTO = new UserResponseDTO();
   userResponseDTO.setAccessToken(token);
   return userResponseDTO;
    }
}
