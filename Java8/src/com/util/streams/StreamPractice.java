package com.util.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {

		//findAny example
		List<Integer> list = Arrays.asList(0,1,2,3,4,5);
		System.out.println(list.stream().findAny().orElseGet(() -> {return 2;}));
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"Ashqar");
		map.put(2,"Ali");
		map.put(4,"Anam");
		map.put(3,"Ali");
		map.put(5,"Anam");
		
		//starts with a
		/*
		 * map.entrySet().stream().filter(k -> k.getValue().startsWith("A")).
		 * forEach(System.out::println);
		 */
		Map<String, String> input = new HashMap<>();
		input.put("a", "1234");
		input.put("b", "2345");
		input.put("c", "3456");
		input.put("d", "4567");
		
		//convert value to Integer and filter with even logic
		/*Map<String,Integer> output = input.entrySet().stream().
				collect(Collectors.toMap(Map.Entry :: getKey, e-> Integer.valueOf(e.getValue()))).
				entrySet().stream().filter(e -> e.getValue() % 2 == 0).
				collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry:: getValue));*/


		//System.out.println(output.toString());
		
		//sort the map based on value first and then on key
		Comparator<Map.Entry<Integer, String>> comp1 = Comparator.comparing(Map.Entry::getValue);
		Comparator<Map.Entry<Integer, String>> comp2 = Comparator.comparing(Map.Entry::getKey);
		
		Map<Integer, String> outputMap = map.entrySet().stream().sorted(comp1.thenComparing(comp2)).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(outputMap);
		
		
	}

}
