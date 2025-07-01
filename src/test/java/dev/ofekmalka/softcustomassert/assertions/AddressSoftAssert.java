package dev.ofekmalka.softcustomassert.assertions;

import org.assertj.core.api.AbstractAssert;

import dev.ofekmalka.data.Address;

public class AddressSoftAssert extends AbstractAssert<AddressSoftAssert, Address> {

	private final BDDCustomSoftAssertions softly;

	public AddressSoftAssert(final Address actual, final BDDCustomSoftAssertions softly) {
		super(actual, AddressSoftAssert.class);
		this.softly = softly;

	}

	public interface AddAddress {
		AddressSoftAssert forAddress(final Address address);
	}

	public AddressSoftAssert hasCity(final String expected) {
		if (!actual.city().equals(expected))
			softly.fail("Expected city to be <%s> but was <%s>", expected, actual.city());
		return this;
	}

	public AddressSoftAssert hasStreet(final String expected) {
		if (!actual.street().equals(expected))
			softly.fail("Expected street to be <%s> but was <%s>", expected, actual.street());
		return this;
	}

	public AddressSoftAssert hasNumber(final int expected) {
		if (actual.number() != expected)
			softly.fail("Expected number to be <%d> but was <%d>", expected, actual.number());
		return this;
	}



}