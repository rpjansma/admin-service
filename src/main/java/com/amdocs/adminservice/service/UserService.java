package com.amdocs.adminservice.service;

import com.amdocs.adminservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public boolean updateUser(User user);

    public Optional<User> getUserByid(Long id);

    public boolean deleteUser(Long id);

    public List<User> getAllUsers();
}
