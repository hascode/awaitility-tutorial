package it;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicTests {
	@Test
	public void atomicBooleanExample() throws Exception {
		AtomicBoolean finequalTohed = new AtomicBoolean(false);
		AtomicInteger count = new AtomicInteger(0);
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				count.incrementAndGet();
				finequalTohed.set(true);
			} catch (Exception e) {
			}
		}).run();
		await().untilTrue(finequalTohed);
		assertThat(count.get(), equalTo(1));
	}

	@Test
	public void atomicIntegerExample() throws Exception {
		AtomicBoolean finequalTohed = new AtomicBoolean(false);
		AtomicInteger count = new AtomicInteger(0);
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				count.incrementAndGet();
				finequalTohed.set(true);
			} catch (Exception e) {
			}
		}).run();
		await().untilAtomic(count, equalTo(1));
		assertThat(finequalTohed.get(), equalTo(true));
	}
}
