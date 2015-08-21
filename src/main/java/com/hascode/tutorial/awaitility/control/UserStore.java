package com.hascode.tutorial.awaitility.control;

import com.hascode.tutorial.awaitility.entity.User;

public class UserStore {
	public void persist(User user) {
		System.out.println("persisting new user: " + user);
		// persist etc ...
	}
}
