package com.khan.Optional;

import java.util.Optional;

public class OptionalDemoCompany {
	
	private String name;
	private Optional<OptionalDemoOffice> office;
	public OptionalDemoCompany(String name, Optional<OptionalDemoOffice> office) {
		super();
		this.name = name;
		this.office = office;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<OptionalDemoOffice> getOffice() {
		return office;
	}
	public void setOffice(Optional<OptionalDemoOffice> office) {
		this.office = office;
	}
	
	

}
