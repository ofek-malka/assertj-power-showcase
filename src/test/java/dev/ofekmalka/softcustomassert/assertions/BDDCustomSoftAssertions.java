package dev.ofekmalka.softcustomassert.assertions;

import org.assertj.core.api.SoftAssertions;

import dev.ofekmalka.data.Address;
import dev.ofekmalka.data.Person;

public class BDDCustomSoftAssertions extends SoftAssertions   {
	public  PersonSoftAssert assertPerson(final Person actual) {
		return proxy(PersonSoftAssert.class, Person.class, actual);
	}

	public AddressSoftAssert assertAddress(final Address actual) {
		return proxy(AddressSoftAssert.class, Address.class, actual);
	}

}

