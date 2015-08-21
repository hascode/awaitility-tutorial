package com.hascode.tutorial.awaitility.entity;

import java.util.UUID;

public class User {
	private String id;
	private String userName;

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public static User create(String userName) {
		return new User(UUID.randomUUID().toString().toUpperCase(), userName);
	}

	private User(String id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}
}
