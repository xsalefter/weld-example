package org.xsalefter.example.weld.ref.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Let say that this class is JPA/Hibernate entity class.
 * 
 * @author xsalefter (xsalefter@gmail.com)
 */
public class Person {

	private Long id;
	private String name;
	private String email;
	private Set<Address> addresses = new HashSet<Address>();
	
	Person() {
		this.id = 0L;
		this.name = "I'm created automatically";
		this.email = "inject@ion.com";
		this.addresses.add(new Address(0L, "Bungalor street", "1 A", this));
	}
	
	public Person(Long id, String name, String email, Address...addresses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
		for (Address address : addresses) this.addresses.add(address);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Person addAddress(Address address) {
		if (address != null) {
			address.setPerson(this);
			this.addresses.add(address);
		}
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Person ID: ").append(this.id).append("\n");
		result.append("Person Name: ").append(this.name).append("\n");
		result.append("Email: ").append(this.email).append("\n");
		result.append("Addresses: \n");
		
		if (this.addresses.isEmpty()) {
			result.append("-");
		} else {
			for (Address address : this.addresses) {
				result.append(address).append("\n");
			}
		}
		
		return result.toString();
	}
}
