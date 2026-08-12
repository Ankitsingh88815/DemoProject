package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(int id, User user);

    User patchUser(int id,User user);
    
    void deleteUser(int id);
}