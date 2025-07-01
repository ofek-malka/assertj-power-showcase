package dev.ofekmalka.data;

public final class Address {

	private final String city;
	private final String street;
	private final int number;

	private Address(final String city, final String street, final int number) {
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public static Address.AddStreet withCity(final String city) {
		return street -> number -> new Address(city, street, number);
	}

	public interface AddStreet {
		Address.addNumber withStreet(String street);
	}

	public interface addNumber {
		Address withNumber(int number);
	}

	public String city() {
		return city;
	}

	public String street() {
		return street;
	}

	public int number() {
		return number;
	}

}
