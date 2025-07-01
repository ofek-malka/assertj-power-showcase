package dev.ofekmalka.collectionassertions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class CollectionAssertionsTest {

	@Test
	void shouldContainElementsInAnyOrder() {
		final var animals = Arrays.asList("dog", "cat", "rabbit");

		assertThat(animals)//
		.contains("cat", "rabbit", "dog") // order doesn't matter
		.doesNotContain("unicorn");
	}

	@Test
	void shouldContainExactlyInGivenOrder() {
		final var numbers = Arrays.asList(1, 2, 3);

		assertThat(numbers).containsExactly(1, 2, 3); // order matters
	}

	@Test
	void shouldBeSorted() {
		final var sortedNumbers = Arrays.asList(1, 2, 3, 4);

		assertThat(sortedNumbers).isSorted();
	}

	@Test
	void shouldBeEmpty() {
		final var emptyList = Collections.emptyList();

		assertThat(emptyList).isEmpty();
	}

	@Test
	void shouldHaveSizeAndElements() {
		final var langs = Set.of("Java", "Python", "Rust");

		assertThat(langs)//
		.hasSize(3)//
		.contains("Java")//
		.doesNotContain("PHP");
	}

	@Test
	void shouldAllMatchPredicate() {
		final var words = List.of("spring", "stream", "structure");

		assertThat(words).allMatch(w -> w.startsWith("s"));
	}

	@Test
	void shouldContainOnlyOnce() {
		final var items = List.of("apple", "banana", "orange");

		assertThat(items).containsOnlyOnce("banana");
	}

	@Test
	void shouldExtractPropertyAndAssert() {
		record Person(String name, int age) {
		}
		final var people = List.of(new Person("Alice", 30), new Person("Bob", 25), new Person("Carol", 35));

		// Extract ages and assert on them
		assertThat(people).extracting(Person::age).containsExactly(30, 25, 35).allMatch(age -> age > 20);
	}

	@Test
	void shouldFilterCollection() {
		final var numbers = List.of(1, 2, 3, 4, 5, 6);

		// Only even numbers
		assertThat(numbers).filteredOn(n -> n % 2 == 0).containsExactly(2, 4, 6);
	}

	@Test
	void shouldContainSequence() {
		final var letters = List.of("a", "b", "c", "d", "e");

		assertThat(letters).containsSequence("b", "c", "d"); // consecutive sequence
	}

	@Test
	void shouldContainSubsequence() {
		final var letters = List.of("a", "b", "c", "d", "e");

		assertThat(letters).containsSubsequence("a", "d", "e"); // elements in order, not necessarily
		// consecutive
	}

	@Test
	void shouldHaveDuplicates() {
		final var fruits = List.of("apple", "banana", "apple", "orange", "banana");

		// Check duplicates exist by comparing size with distinct size
		assertThat((long) fruits.size()).isGreaterThan(fruits.stream().distinct().count());
	}

	@Test
	void shouldNotHaveDuplicates() {
		final var uniqueItems = List.of("x", "y", "z");

		assertThat(uniqueItems).doesNotHaveDuplicates();
	}

	@Test
	void shouldContainExactlyElementsOfAnotherList() {
		final var list1 = List.of("one", "two", "three");
		final var list2 = List.of("one", "two", "three");

		assertThat(list1).containsExactlyElementsOf(list2);
	}

	@Test
	void shouldContainAnyElementOfAnotherCollection() {
		final var collection1 = List.of("cat", "dog", "rabbit");
		final var collection2 = List.of("fox", "dog", "lion");

		assertThat(collection1).containsAnyElementsOf(collection2);
	}

	@Test
	void shouldSatisfyAllConditions() {
		final var numbers = List.of(10, 20, 30, 40);

		assertThat(numbers)//

		.hasSize(4)//
		.contains(20, 30)//
		.allMatch(n -> n % 10 == 0);

	}

	@Test
	void shouldHaveAtLeastOneElementMatchingCondition() {
		final var words = List.of("hello", "world", "java", "assertj");

		assertThat(words).anyMatch(w -> w.startsWith("a"));
	}

	@SuppressWarnings("cast")
	@Test
	void shouldContainOnlyInstanceOf() {
		final var numbers = List.of(1, 2, 3, 4);
		assertThat(numbers).allMatch(n -> n instanceof Integer);
	}

	@Test
	void shouldHaveExactlyElementOfGivenType() {
		final var mixed = List.of(1, "two", 3.0);
		final var instanceOfString = new Condition<>(n -> n instanceof String, "instance Of String");

		assertThat(mixed).haveExactly(1, instanceOfString);
	}

}
