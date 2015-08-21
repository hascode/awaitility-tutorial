package it;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.hascode.tutorial.awaitility.Application;
import com.hascode.tutorial.awaitility.boundary.UserService;
import com.hascode.tutorial.awaitility.control.UserStore;
import com.hascode.tutorial.awaitility.entity.User;

public class CreateUserIT {
	private static final String USERNAME_1 = "xoxo";
	private static final String USERNAME_2 = "fooo";

	UserService service = Application.CREATE.getUserService();
	UserStore store = Application.CREATE.getUserStore();

	@Test
	public void shouldCreateUsers() throws Exception {
		service.createUser(USERNAME_1);
		await().pollDelay(2, TimeUnit.SECONDS).until(() -> store.all().size(), is(1));
		User user1 = store.byName(USERNAME_1);
		assertThat(user1.getUserName(), equalTo(USERNAME_1));
		assertThat(user1.getId(), notNullValue());

		service.createUser(USERNAME_2);
		await().pollDelay(2, TimeUnit.SECONDS).until(() -> store.all().size(), is(2));
		User user2 = store.byName(USERNAME_2);
		assertThat(user2.getUserName(), equalTo(USERNAME_2));
		assertThat(user2.getId(), notNullValue());
	}
}
