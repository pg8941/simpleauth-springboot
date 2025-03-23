// src/main/java/com/example/simpleauth/service/UserService.java
package com.example.simpleauth.service;

import com.example.simpleauth.model.Role;
import com.example.simpleauth.model.User;
import com.example.simpleauth.repository.RoleRepository;
import com.example.simpleauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User registerUser(String username, String password, String roleName) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        Role role = roleRepository.findByName(roleName).orElseGet(() -> roleRepository.save(new Role(roleName)));
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(username, encodedPassword, roles);
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        logger.debug("Finding user by username: {}, result: {}", username, user);
        return user;
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}