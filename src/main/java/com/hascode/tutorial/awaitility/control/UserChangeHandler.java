package com.hascode.tutorial.awaitility.control;

import com.google.common.eventbus.Subscribe;
import com.hascode.tutorial.awaitility.entity.UserCreateEvent;

public class UserChangeHandler {
	private final UserStore userStore;

	public UserChangeHandler(UserStore userStore) {
		this.userStore = userStore;
	}

	@Subscribe
	public void handleUserCreate(UserCreateEvent e) {
		userStore.persist(e.getUser());
	}
}
