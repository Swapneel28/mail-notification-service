package no.adstate.mail.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no.adstate.mail.notification.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
