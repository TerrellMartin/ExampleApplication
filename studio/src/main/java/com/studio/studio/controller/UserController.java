package com.studio.studio.controller;

import com.studio.studio.model.User;
import com.studio.studio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
	
	private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;
    
    //finds all users stored in user table
    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }
    
    /*
    @GetMapping("/users/{userid}")
    public List<User> getSpecificUser(long userid){
    	return userRepository.findById(userid);
    }
    */

    //creates a new user through a REST call
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    //updates a specific user by searching through db for user id
    @PutMapping("/users/{userid}")
    public Optional<User> updateUser(@PathVariable Long userId,
                                     @Valid @RequestBody User userRequest){
        return userRepository.findById(userId)
                .map(user -> {
                    user.setFirstname(userRequest.getFirstname());
                    user.setLastname((userRequest.getLastname()));
                    user.setAge(userRequest.getAge());
                    user.setUsername(userRequest.getUsername());
                    user.setPassword(userRequest.getPassword());
                    return userRepository.save(user);
                });
    }
    
    //user can set appointment


}
