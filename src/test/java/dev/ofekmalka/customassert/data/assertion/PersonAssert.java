package dev.ofekmalka.customassert.data.assertion;


import org.assertj.core.api.AbstractAssert;

import dev.ofekmalka.data.Person;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

	private PersonAssert(final Person actual) {
		super(actual, PersonAssert.class);
	}

	public static PersonAssert assertPerson(final Person actual) {
		return new PersonAssert(actual);
	}

	public PersonAssert hasName(final String name) {
		isNotNull();
		if (!actual.name().equals(name))
			failWithMessage("Expected name to be <%s> but was <%s>", name, actual.name());
		return this;
	}

	public PersonAssert isAdult() {
		isNotNull();
		if (actual.age() < 18)
			failWithMessage("Expected age to be 18 or more, but was <%s>", actual.age());
		return this;
	}

	public PersonAssert isEmployed() {
		isNotNull();
		if (!actual.isEmployed())
			failWithMessage("Expected person to be employed");
		return this;
	}


	public PersonAssert isMinor() {
		isNotNull();
		if (actual.age() >= 18)
			failWithMessage("Expected to be minor (age < 18) but was <%d>", actual.age());

		return this;
	}

	public PersonAssert isUnemployed() {
		isNotNull();
		if (actual.isEmployed())
			failWithMessage("Expected person to be employed");
		return this;
	}

	public AddressAssert hasAddress() {
		isNotNull();
		return AddressAssert.assertAddress(actual.address());
	}
}
