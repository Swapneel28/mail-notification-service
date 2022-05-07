package no.adstate.mail.notification.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import no.adstate.mail.notification.dto.UserDto;
import no.adstate.mail.notification.entity.User;
import no.adstate.mail.notification.repository.SubscriptionRepository;
import no.adstate.mail.notification.repository.UserRepository;
import no.adstate.mail.notification.util.Adapter;
import no.adstate.mail.notification.util.JsonConversionUtil;

import static no.adstate.mail.notification.util.Constants.NOT_ALLOWED_MAIL_SUFFIX;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserRegistrationListener {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@KafkaListener(topics = "user-registration", groupId = "user")
	public void listen(String message) {
		UserDto userDto = JsonConversionUtil.unwrapJsonStringToObject(message);
		if (!userDto.getEmail().endsWith(NOT_ALLOWED_MAIL_SUFFIX)) {
			User user = Adapter.adaptToUserEntity(userDto);
			if (userDto.getMailList() == null) {
				user.setSubscriptions(null);
			} else {
				user.setSubscriptions(Adapter.adaptToSubscriptionEntity(userDto));
			}
			User createdUser = userRepository.save(user);
			Optional.ofNullable(user.getSubscriptions()).orElse(Collections.emptySet()).forEach(s -> {
				  s.setUser(createdUser);
				  subscriptionRepository.save(s);
			});
			
		}
	}
}
