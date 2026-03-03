package com.fitness.activityService.service;

import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import com.fitness.activityService.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .additionalMetrics(request.getAdditionalMetrics())
                .startTime(request.getStartTime())
                .caloriesBurned(request.getCaloriesBurned())
                .duration(request.getDuration())
                .build();

        Activity savedActivity=activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }

    public List<ActivityResponse> getUserActivity(String userId) {
        List<Activity> activities= activityRepository.getByUserId(userId);
        return activities.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ActivityResponse mapToResponse(Activity activity) {
        return ActivityResponse.builder()
                .id(activity.getId())
                .userId(activity.getUserId())
                .additionalMetrics(activity.getAdditionalMetrics())
                .caloriesBurned(activity.getCaloriesBurned())
                .type(activity.getType())
                .duration(activity.getDuration())
                .startTime(activity.getStartTime())
                .updatedAt(activity.getUpdatedAt())
                .createdAt(activity.getCreatedAt())
                .build();
    }


    public ActivityResponse getActivityById(String activityId) {
        return activityRepository.findById(activityId).map(this::mapToResponse)
                .orElseThrow(()->new RuntimeException("Activity not found with id: "+activityId));
    }
}
