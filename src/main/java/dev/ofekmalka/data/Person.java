package dev.ofekmalka.data;

public final class Person {

	private final String name;
	private final int age;
	private final boolean employed;
	private final Address address;

	private Person(final String name, final int age, final boolean employed, final Address address) {
		this.name = name;
		this.age = age;
		this.employed = employed;
		this.address = address;
	}

	public static AddAge withName(final String name) {
		return age -> new EmployedStep(name, age);
	}

	public interface AddAge {
		IsEmployed withAge(int age);
	}

	public interface IsEmployed {
		AddAddress employed();

		AddAddress unemployed();
	}

	// ✅ This is private and hides internal boolean logic
	private static final class EmployedStep implements IsEmployed {
		private final String name;
		private final int age;

		private EmployedStep(final String name, final int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public AddAddress employed() {
			return address -> new Person(name, age, true, address);
		}

		@Override
		public AddAddress unemployed() {
			return address -> new Person(name, age, false, address);
		}
	}

	public interface AddAddress {
		Person withAddress(Address address);
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public boolean isEmployed() {
		return employed;
	}

	public Address address() {
		return address;
	}

}