package com.hascode.tutorial.awaitility.boundary;

import com.google.common.eventbus.EventBus;
import com.hascode.tutorial.awaitility.entity.User;
import com.hascode.tutorial.awaitility.entity.UserCreateEvent;

public class UserService {
	private final EventBus eventBus;

	public UserService(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void createUser(String userName) {
		eventBus.post(new UserCreateEvent(User.create(userName)));
	}
}
