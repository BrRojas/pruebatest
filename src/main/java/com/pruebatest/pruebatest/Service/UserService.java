package com.pruebatest.pruebatest.Service;

import com.pruebatest.pruebatest.Entity.UserRepository;
import com.pruebatest.pruebatest.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }



}
