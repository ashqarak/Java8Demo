package com.khan.Optional;

import java.util.Optional;

public class OptionalDemoAddress {
	
	private Optional<String> street;
	private Optional<String> city;
	
	public OptionalDemoAddress(Optional<String> street, Optional<String> city) {
		super();
		this.street = street;
		this.city = city;
	}
	public Optional<String> getStreet() {
		return street;
	}
	public void setStreet(Optional<String> street) {
		this.street = street;
	}
	public Optional<String> getCity() {
		return city;
	}
	public void setCity(Optional<String> city) {
		this.city = city;
	}
	
	

}
