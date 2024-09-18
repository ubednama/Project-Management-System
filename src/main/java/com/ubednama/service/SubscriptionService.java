package com.ubednama.service;

import com.ubednama.model.PlanType;
import com.ubednama.model.Subscription;
import com.ubednama.model.User;
import org.springframework.stereotype.Service;

//@Service
public interface SubscriptionService {
    Subscription createSubscription(User user);

    Subscription getUserSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
