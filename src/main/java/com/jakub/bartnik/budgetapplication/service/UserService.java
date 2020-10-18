package com.jakub.bartnik.budgetapplication.service;

import com.jakub.bartnik.budgetapplication.model.User;
import com.jakub.bartnik.budgetapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void delete (Long userId){
        userRepository.deleteById(userId);
    }

    public Optional<User> findUser(Long userId) {

        return userRepository.findById(userId);
    }
}
