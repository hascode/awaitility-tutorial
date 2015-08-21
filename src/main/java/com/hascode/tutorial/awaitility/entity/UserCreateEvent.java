package com.hascode.tutorial.awaitility.entity;

import java.time.LocalDateTime;

public class UserCreateEvent {
	private User user;
	private LocalDateTime created;

	public UserCreateEvent(User user) {
		this.user = user;
		this.created = LocalDateTime.now();
	}

	public User getUser() {
		return user;
	}

	public LocalDateTime getCreated() {
		return created;
	}
}
