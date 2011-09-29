package org.xsalefter.example.weld.injection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.xsalefter.example.weld.ref.domain.Address;
import org.xsalefter.example.weld.ref.domain.Person;

/**
 * Demo how to doing a simple injection.
 * 
 * @author xsalefter (xsalefter@gmail.com)
 */
public class SimpleInjection {
	
	private Person person;
	private Address address;
	
	/**
	 * Look, we just @{@link Inject} the person. We could add immutability to 
	 * our classes by defining constructing {@link InjectionPoint} in the 
	 * constructor.
	 * @param person to @{@link Inject}.
	 */
	@Inject
	public SimpleInjection(Person person, Address address) {
		this.person = person;
		this.address = address;
	}
	
	/** 
	 * After this {@link SimpleInjection} class is instantiated by 
	 * container, this method (which is marked with {@link PostConstruct} 
	 * annotation) will be called automatically, because this class become a 
	 * reference / {@link InjectionPoint} / @{@link Inject}ed property/field in 
	 * {@link Main} class.
	 */
	@PostConstruct
	public void run() {
		System.out.println(this.person);
	}
	
	/**
	 * Do something with person and address.
	 */
	public void registerAddressToPerson() {
		this.address.setPerson(this.person);
		this.person.addAddress(this.address);
		
		System.out.println(this.person);
	}

	public Person getPerson() {
		return person;
	}

	public Address getAddress() {
		return address;
	}
}
