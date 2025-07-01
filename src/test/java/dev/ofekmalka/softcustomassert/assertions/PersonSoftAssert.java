package dev.ofekmalka.softcustomassert.assertions;

import org.assertj.core.api.AbstractAssert;

import dev.ofekmalka.data.Person;

public class PersonSoftAssert extends AbstractAssert<PersonSoftAssert, Person> {
	private final BDDCustomSoftAssertions softly;

	private PersonSoftAssert(final Person actual, final BDDCustomSoftAssertions softly) {
		super(actual, PersonSoftAssert.class);
		this.softly = softly;
	}

	public static AddPerson use(final BDDCustomSoftAssertions softly) {
		return person -> new PersonSoftAssert(person, softly);
	}

	public interface AddPerson {
		PersonSoftAssert forPerson(final Person person);
	}

	public PersonSoftAssert hasName(final String expected) {

		if (!actual.name().equals(expected))
			softly.fail("Expected name to be <%s> but was <%s>", expected, actual.name());
		return this;
	}

	public PersonSoftAssert isAdult() {

		if (actual.age() < 18)
			softly.fail("Expected to be adult (age >= 18) but was <%d>", actual.age());

		return this;
	}

	public PersonSoftAssert isMinor() {

		if (actual.age() >= 18)
			softly.fail("Expected to be minor (age < 18) but was <%d>", actual.age());

		return this;
	}

	public PersonSoftAssert isEmployed() {

		if (!actual.isEmployed())
			softly.fail("Expected to be employed");

		return this;
	}

	public PersonSoftAssert isUnemployed() {

		if (actual.isEmployed())
			softly.fail("Expected to be unemployed");

		return this;
	}

	public AddressSoftAssert hasAddress() {
		return new AddressSoftAssert(actual.address(), softly);
	}

}