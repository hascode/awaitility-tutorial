package com.hascode.tutorial.awaitility.control;

import com.google.common.eventbus.Subscribe;
import com.hascode.tutorial.awaitility.entity.UserCreatedEvent;

public class UserChangeHandler {
	private final UserStore userRepository;

	public UserChangeHandler(UserStore userRepository) {
		this.userRepository = userRepository;
	}

	@Subscribe
	public void handleUserCreate(UserCreatedEvent e) {
		userRepository.persist(e.getUser());
	}
}
