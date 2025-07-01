package dev.ofekmalka.softcustomassert;

import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import dev.ofekmalka.data.Address;
import dev.ofekmalka.data.Person;
import dev.ofekmalka.softcustomassert.assertions.BDDCustomSoftAssertions;
import dev.ofekmalka.softcustomassert.assertions.PersonSoftAssert;

@ExtendWith(SoftAssertionsExtension.class)
public class CustomAssertionsTest {

	@Test
	void personShouldHaveValidDetails(final BDDCustomSoftAssertions softly) {


		final var person = Person//
				.withName("Ofek")//
				.withAge(29)//
				.employed()//
				.withAddress(//

						Address.withCity("Tel Aviv")//
						.withStreet("Dizengoff")//
						.withNumber(101)//
						);//


		PersonSoftAssert.use(softly)


		.forPerson(person)
		.hasName("Ofek")//
		.isAdult()//
		.isEmployed()//
		.hasAddress()//
		.hasCity("Tel Aviv")//
		.hasStreet("Dizengoff")//
		.hasNumber(101);//
	}
}
