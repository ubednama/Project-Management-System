package com.ubednama.service;

import com.ubednama.modal.PlanType;
import com.ubednama.modal.Subscription;
import com.ubednama.modal.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);

    Subscription getUserSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
