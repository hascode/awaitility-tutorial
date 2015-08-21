package com.hascode.tutorial.awaitility;

import com.hascode.tutorial.awaitility.boundary.UserService;

public class Main {
	public static void main(String[] args) {
		Application app = Application.CREATE;
		UserService userService = app.getUserService();
		// create a new user
		userService.createUser("irbaboon");
	}
}
