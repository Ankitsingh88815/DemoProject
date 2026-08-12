package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(int id) {

        return userRepository.findById(id)
                .orElseThrow(() -> 
                    new RuntimeException("User not found with id " + id));
    }


    @Override
    public User updateUser(int id, User user) {

        User existingUser = getUserById(id);

        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setCollege(user.getCollege());

        return userRepository.save(existingUser);
    }

    @Override
    public User patchUser(int id, User user){
        User existUser = getUserById(id);
        // User exist = getUserById(id);
        if(user.getAddress()!=null){
            existUser.setAddress(user.getAddress());
        }
        if(user.getName()!=null){
            existUser.setName(user.getName());
        }
        if(user.getCollege()!=null){
            existUser.setCollege(user.getCollege());
        }

        return userRepository.save(existUser);
    }

    @Override
    public void deleteUser(int id) {

        userRepository.deleteById(id);
    }
}