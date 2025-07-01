package dev.ofekmalka.customassert.data.assertion;


import org.assertj.core.api.AbstractAssert;

import dev.ofekmalka.data.Address;

public class AddressAssert extends AbstractAssert<AddressAssert, Address> {

	private AddressAssert(final Address actual) {
		super(actual, AddressAssert.class);
	}

	public static AddressAssert assertAddress(final Address actual) {
		return new AddressAssert(actual);
	}

	public AddressAssert hasCity(final String city) {
		isNotNull();
		if (!actual.city().equals(city))
			failWithMessage("Expected city to be <%s> but was <%s>", city, actual.city());
		return this;
	}

	public AddressAssert hasStreet(final String street) {
		isNotNull();
		if (!actual.street().equals(street))
			failWithMessage("Expected street to be <%s> but was <%s>", street, actual.street());
		return this;
	}

	public AddressAssert hasNumber(final int number) {
		isNotNull();
		if (actual.number() != number)
			failWithMessage("Expected house number to be <%s> but was <%s>", number, actual.number());
		return this;
	}
}
