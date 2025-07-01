package dev.ofekmalka.stringassertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringAssertionsTest {

	@Test
	void shouldStartAndEndWith() {
		assertThat("AssertJ makes assertions fluent")//
		.startsWith("AssertJ")//
		.endsWith("fluent");//
	}

	@Test
	void shouldContainAndNotContain() {
		assertThat("I love Java and AssertJ")//
		.contains("Java")//
		.containsIgnoringCase("assertj")//
		.doesNotContain("Python");//
	}

	@Test
	void shouldBeEmpty() {
		assertThat("").isEmpty();
	}

	@Test
	void shouldBeBlank() {
		assertThat("   ").isBlank();
	}

	@Test
	void shouldMatchRegex() {
		assertThat("user@example.com")//
		.matches("^[\\w.%-]+@\\w+\\.\\w+$");
	}

	@Test
	void shouldBeEqualIgnoringCaseAndWhitespace() {
		assertThat("Hello World")//
		.isEqualToIgnoringCase("hello WORLD")//
		.isEqualToIgnoringWhitespace("    Hello          World      ");
	}

	@Test
	void shouldContainOnlyDigits() {
		assertThat("123456").containsOnlyDigits();
	}

	@Test
	void shouldcontainsPattern() {
		assertThat("123abc").containsPattern("[a-z]+");
	}

	@Test
	void shouldHaveSpecificLength() {
		assertThat("Assert").hasSize(6);
	}

	@Test
	void shouldSatisfyCustomCondition() {
		assertThat("ABCD1234")//
		.contains("123")//
		.hasSize(8)//
		.doesNotContain("XYZ");//

	}

	@Test
	void shouldExtractSubstringAndAssert() {
		final var versionString = "version: 1.2.3";
		final var version = versionString.substring("version: ".length());
		assertThat(version).isEqualTo("1.2.3");
	}

	@Test
	void shouldBeEqualToNormalizingNewlines() {
		final var unix = "line1\nline2";
		final var windows = "line1\r\nline2";
		assertThat(unix).isEqualToNormalizingNewlines(windows);
	}
}
