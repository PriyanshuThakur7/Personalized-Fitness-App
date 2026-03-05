package com.fitness.userService.service;

import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.model.User;
import com.fitness.userService.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public @Nullable UserResponse registerUser(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw  new RuntimeException("User by same emailId already exists.");
        }

        User user=new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());

        User savedUser=userRepository.save(user);

        UserResponse userResponse=new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setName(savedUser.getName());
        userResponse.setGender(savedUser.getGender());
        userResponse.setGoal(savedUser.getGoal());
        userResponse.setHeight(savedUser.getHeight());
        userResponse.setWeight(savedUser.getWeight());
        return userResponse;
    }

    public @Nullable UserResponse getUser(String userID) {
        User savedUser=userRepository.findById(userID)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        UserResponse userResponse=new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setName(savedUser.getName());
        userResponse.setGender(savedUser.getGender());
        userResponse.setGoal(savedUser.getGoal());
        userResponse.setHeight(savedUser.getHeight());
        userResponse.setWeight(savedUser.getWeight());
        return userResponse;
    }

    public Boolean existsById(String userId) {
        return userRepository.existsById(userId);
    }
}
