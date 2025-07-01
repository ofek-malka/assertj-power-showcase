package dev.ofekmalka.exceptionassertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class ExceptionAssertionsTest {

	@Test
	void shouldThrowIllegalArgumentException() {
		assertThatThrownBy(() -> {
			throw new IllegalArgumentException("Invalid argument");
		})
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining("Invalid");
	}

	@Test
	void shouldCatchThrowableAndAssertOnIt() {
		final var thrown = catchThrowable(() -> {
			throw new RuntimeException("Boom!");
		});

		assertThat(thrown)
		.isInstanceOf(RuntimeException.class)
		.hasMessage("Boom!");
	}

	@SuppressWarnings("null")
	@Test
	void shouldAssertOnExactExceptionType() {
		assertThatExceptionOfType(NullPointerException.class)
		.isThrownBy(() -> {
			final String s = null;
			s.length(); // will throw
		})
		.withMessageContaining("null");
	}

	@Test
	void shouldHandleCheckedExceptions() {
		assertThatThrownBy(() -> {
			throw new java.io.IOException("I/O failure");
		})
		.isInstanceOf(java.io.IOException.class)
		.hasMessage("I/O failure");
	}

	@Test
	void shouldAssertCauseOfException() {
		final Throwable cause = new IllegalArgumentException("Cause");
		final Throwable exception = new RuntimeException("Wrapper", cause);

		assertThatThrownBy(() -> { throw exception; })
		.isInstanceOf(RuntimeException.class)
		.hasCauseInstanceOf(IllegalArgumentException.class)
		.hasMessage("Wrapper");
	}
}
