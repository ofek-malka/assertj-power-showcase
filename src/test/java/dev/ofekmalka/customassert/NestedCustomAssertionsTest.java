package dev.ofekmalka.customassert;

import static dev.ofekmalka.customassert.data.assertion.PersonAssert.assertPerson;

import org.junit.jupiter.api.Test;

import dev.ofekmalka.data.Address;
import dev.ofekmalka.data.Person;


public class NestedCustomAssertionsTest {

	@Test
	void personShouldHaveCorrectAddress() {
		final var address =  Address//

				.withCity("Tel Aviv")//
				.withStreet("Dizengoff")//
				.withNumber(101)//
				;
		final var person =  Person//
				.withName("Ofek")//
				.withAge(29)//
				.employed()//
				.withAddress(address);//


		assertPerson(person)
		.hasName("Ofek")//
		.isAdult()//
		.isEmployed()//
		.hasAddress()////
		.hasCity("Tel Aviv")//
		.hasStreet("Dizengoff")//
		.hasNumber(101);//
	}



}




