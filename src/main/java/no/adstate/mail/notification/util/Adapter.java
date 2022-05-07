package no.adstate.mail.notification.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.adstate.mail.notification.dto.UserDto;
import no.adstate.mail.notification.entity.Subscription;
import no.adstate.mail.notification.entity.User;
import static no.adstate.mail.notification.util.Constants.DEFAULT_MAIL_SUBSCRIPTION;

public class Adapter {

	public static Set<Subscription> adaptToSubscriptionEntity(final UserDto userDto) {
		if (userDto.getMailList() != null && !userDto.getMailList().isEmpty()) {
			List<String> subs = Arrays.asList(userDto.getMailList().split(","));
			Set<Subscription> subscriptions = new HashSet<Subscription>();
			subs.forEach(s -> {
				Subscription subscription = new Subscription();
				subscription.setUser(adaptToUserEntity(userDto));
				if (s.equals(DEFAULT_MAIL_SUBSCRIPTION))
					subscription.setSubscription(DEFAULT_MAIL_SUBSCRIPTION);
				subscriptions.add(subscription);
			});
			return subscriptions;
		} else {
			return null;
		}

	}

	public static User adaptToUserEntity(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		return user;
	}
}
