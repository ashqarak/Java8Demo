package com.util.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStremObjects {

	public static void main(String[] args) {
		
		Stream<String> stream1 = Stream.of("Ashqar");
		Stream<Integer> stream2 = Stream.of(1,2,3,4,1,2,5,6,4,6,3);
		String s = "Ashqar";
		//concat
		/*
		 * Stream.concat(stream1, stream2).filter((a) -> a.length() > 3).
		 * collect(Collectors.toList()).forEach(System.out::println);
		 */
		//conditional filter  
		/*
		 * List<Product> list = getProducts() .stream().filter(product ->
		 * product.getPrice() > 30000f).collect(Collectors.toList());
		 */
		 
		// get the length of each element
		//Stream.concat(stream1,stream2).map(str -> str.length()).forEach(System.out::println);
		
		//get the count of each character
		Map<Integer,Long> map1 = stream2.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map1.forEach((k,v) -> {
			System.out.println(k + " : " + v);
		} );
		
		getProducts().stream().sorted((a,b) -> {
			return (int) (b.getPrice() - a.getPrice());
		}).forEach(System.out::println);
		
		getProducts().stream().sorted(Comparator.comparingInt(Product :: getId)).forEach(System.out::println);
		
		
	}
	
	private static List<Product> getProducts(){
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(new Product(1,"Apple",20000f));
		listProduct.add(new Product(2,"Windows",30000f));
		listProduct.add(new Product(3,"Linux",40000f));
		listProduct.add(new Product(4,"CentOS",50000f));
		return listProduct;
	}

}

class Product{
	private int id;
	private String name;
	private float price;
	
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
