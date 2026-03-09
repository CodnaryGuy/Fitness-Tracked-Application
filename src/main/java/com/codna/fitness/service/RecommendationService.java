package com.codna.fitness.service;

import com.codna.fitness.dto.RecommendationRequest;
import com.codna.fitness.exception.ActivityNotFoundException;
import com.codna.fitness.exception.UserNotFoundException;
import com.codna.fitness.model.Activity;
import com.codna.fitness.model.Recommendation;
import com.codna.fitness.model.User;
import com.codna.fitness.repository.ActivityRepository;
import com.codna.fitness.repository.RecommendationRepository;
import com.codna.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public Recommendation generateRecommendation(RecommendationRequest recommendationRequest) {
        User user = userRepository.findById(recommendationRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found: " + recommendationRequest.getUserId()));

        Activity activity = activityRepository.findById(recommendationRequest.getActivityId())
                .orElseThrow(() -> new ActivityNotFoundException("Activity Not Found: " + recommendationRequest.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(recommendationRequest.getImprovements())
                .suggestions(recommendationRequest.getSuggestions())
                .safety(recommendationRequest.getSafety())
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
