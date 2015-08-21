package com.hascode.tutorial.awaitility;

import com.google.common.eventbus.EventBus;
import com.hascode.tutorial.awaitility.boundary.UserService;
import com.hascode.tutorial.awaitility.control.UserChangeHandler;
import com.hascode.tutorial.awaitility.control.UserStore;

public enum Application {
	CREATE;

	private final EventBus eventBus = new EventBus();
	private final UserStore userStore = new UserStore();
	private final UserService userService = new UserService(eventBus);

	private Application() {
		eventBus.register(new UserChangeHandler(userStore));
	}

	public UserService getUserService() {
		return userService;
	}

	public UserStore getUserStore() {
		return userStore;
	}
}
