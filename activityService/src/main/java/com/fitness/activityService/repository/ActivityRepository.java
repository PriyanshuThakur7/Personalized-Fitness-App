package com.fitness.activityService.repository;

import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity,String> {
    List<Activity> getByUserId(String userId);
}
