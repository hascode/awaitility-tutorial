package it;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicTests {
	@Test
	public void atomicBooleanExample() throws Exception {
		AtomicBoolean finished = new AtomicBoolean(false);
		AtomicInteger count = new AtomicInteger(0);
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				count.incrementAndGet();
				finished.set(true);
			} catch (Exception e) {
			}
		}).run();
		await().untilTrue(finished);
		assertThat(count.get(), is(1));
	}

	@Test
	public void atomicIntegerExample() throws Exception {
		AtomicBoolean finished = new AtomicBoolean(false);
		AtomicInteger count = new AtomicInteger(0);
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				count.incrementAndGet();
				finished.set(true);
			} catch (Exception e) {
			}
		}).run();
		await().untilAtomic(count, is(1));
		assertThat(finished.get(), is(true));
	}
}
