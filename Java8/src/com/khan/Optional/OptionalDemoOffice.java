package com.khan.Optional;

import java.util.Optional;

public class OptionalDemoOffice {
	
	private String id;
	private Optional<OptionalDemoAddress> address;
	
	public OptionalDemoOffice(String id, Optional<OptionalDemoAddress> address) {
		super();
		this.id = id;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Optional<OptionalDemoAddress> getAddress() {
		return address;
	}
	public void setAddress(Optional<OptionalDemoAddress> address) {
		this.address = address;
	}
	
	

}
