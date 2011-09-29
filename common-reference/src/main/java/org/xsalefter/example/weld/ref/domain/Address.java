package org.xsalefter.example.weld.ref.domain;

public class Address {

	private Long id;
	private String street;
	private String number;
	private Person person;
	
	public Address() {
		this.id = 100L;
		this.street = "Long Street";
		this.number = "999";
	}
	
	public Address(Long id, String street, String number, Person person) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + ", Street: " + this.street + ", " + this.number;
	}
}
