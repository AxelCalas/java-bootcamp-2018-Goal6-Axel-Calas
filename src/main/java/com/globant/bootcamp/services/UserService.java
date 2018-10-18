package com.globant.bootcamp.services;

import com.globant.bootcamp.objects.User;
import com.globant.bootcamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> showAllUsers(){
        return userRepository.findAll();
    }

    public User showUser(Long user_id){
        return userRepository.findById(user_id).get();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(Long user_id){
        Optional optional = userRepository.findById(user_id);
        if(optional.isPresent()){
            userRepository.deleteById(user_id);
            return "Deleted";
        } else {
            return "Not found";
        }
    }
}
