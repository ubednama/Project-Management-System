package com.ubednama.repository;

import com.ubednama.modal.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByUserId(Long userId);


    //4:57:30
}
