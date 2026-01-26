package com.fitness.userService.dto;

import com.fitness.userService.model.Gender;
import com.fitness.userService.model.Goal;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String password;
    private String name;
    private Gender gender;
    private int weight;
    private int height;
    private Goal goal;
}
