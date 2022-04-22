package com.khan.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptinalDemo1 {

	public static void main(String[] args) {
		
		Optional<OptionalDemoAddress> address1 = Optional.of(new OptionalDemoAddress(
				Optional.ofNullable(null), Optional.of("New York")));
		Optional<OptionalDemoOffice> office1 = Optional.of(new OptionalDemoOffice(
				"OF1", address1));
		Optional<OptionalDemoCompany> company1 = Optional.of(new OptionalDemoCompany(
				"Door Never Closed", office1));
		
		company1.flatMap(OptionalDemoCompany::getOffice).
				flatMap(OptionalDemoOffice :: getAddress).
				flatMap(OptionalDemoAddress :: getCity).
				ifPresent(System.out::println);
		
		List<String> words = Arrays.asList("Ashqar", "Ali", "Khan");
		String str = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
		System.out.println(str);
	}
}
