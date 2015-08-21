package com.hascode.tutorial.awaitility.control;

import java.util.HashSet;
import java.util.Set;

import com.hascode.tutorial.awaitility.entity.User;

public class UserStore {
	private static final Set<User> STORE = new HashSet<>();

	public void persist(User user) {
		System.out.println("persisting new user: " + user);
		STORE.add(user);
	}

	public Set<User> all() {
		return new HashSet<>(STORE);
	}

	public User byName(String userName) {
		return STORE.stream().filter(user -> user.getUserName().equals(userName)).findFirst().get();
	}
}
