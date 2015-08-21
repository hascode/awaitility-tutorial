package com.hascode.tutorial.awaitility.boundary;

import com.google.common.eventbus.EventBus;
import com.hascode.tutorial.awaitility.control.UserChangeHandler;
import com.hascode.tutorial.awaitility.control.UserStore;
import com.hascode.tutorial.awaitility.entity.User;
import com.hascode.tutorial.awaitility.entity.UserCreatedEvent;

public class Main {
	public static void main(String[] args) {
		UserStore userRepository = new UserStore();
		EventBus eventBus = new EventBus();
		eventBus.register(new UserChangeHandler(userRepository));

		// ..

		UserCreatedEvent evt = new UserCreatedEvent(User.create("fflintstone"));
		eventBus.post(evt);
	}
}
