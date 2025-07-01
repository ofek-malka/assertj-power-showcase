package dev.ofekmalka.propertyassertions;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PropertyAssertionsTest {

	record Person(String name, int age, boolean employed) {}

	@Test
	void shouldExtractSingleProperty() {
		final var person = new Person("Alice", 30, true);

		assertThat(person)
		.extracting(Person::name)
		.isEqualTo("Alice");
	}

	@Test
	void shouldExtractMultipleProperties() {
		final var person = new Person("Bob", 25, false);

		assertThat(person)
		.extracting(Person::name, Person::age)
		.containsExactly("Bob", 25);
	}

	@Test
	void shouldExtractPropertiesAsTuple() {
		final var person = new Person("Carol", 40, true);

		assertThat(person)
		.extracting("name", "age")
		.containsExactly("Carol", 40);
	}

	@Test
	void shouldExtractFromListOfObjects() {
		final var people = List.of(
				new Person("Alice", 30, true),
				new Person("Bob", 25, false)
				);

		assertThat(people)
		.extracting(Person::name)
		.containsExactly("Alice", "Bob");
	}

	@Test
	void shouldExtractAndMatchCondition() {
		final var person = new Person("Daniel", 22, true);

		assertThat(person)
		.extracting(Person::age)
		.as("Check if adult")
		.satisfies(age -> assertThat((int) age).isGreaterThanOrEqualTo(18));
	}
}
