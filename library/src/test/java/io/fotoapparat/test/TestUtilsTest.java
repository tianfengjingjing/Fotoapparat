package io.fotoapparat.test;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.assertEquals;

public class TestUtilsTest {

	@Test
	public void resultOf() throws Exception {
		// Given
		FutureTask<String> task = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Result";
			}
		});

		// When
		String result = TestUtils.resultOf(task);

		// Then
		assertEquals(
				"Result",
				result
		);
	}

	@Test
	public void immediateFuture() throws Exception {
		// Given
		Future<String> future = TestUtils.immediateFuture("Result");

		// When
		String result = future.get();

		// Then
		assertEquals(
				"Result",
				result
		);
	}
}