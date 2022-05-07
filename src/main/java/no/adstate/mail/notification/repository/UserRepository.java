package no.adstate.mail.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no.adstate.mail.notification.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
