import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSortExample {

	public static void main(String[] args) {

		Map<Employee,Integer> map1 = new HashMap<Employee,Integer>();
		map1.put(new Employee(1, "Ashqar", 30, 35000), 100);
		map1.put(new Employee(2, "Ali", 40, 15000), 200);
		map1.put(new Employee(3, "Khan", 50, 25000), 300);
		map1.put(new Employee(4, "Sahil", 20, 45000), 400);
		
		/*map1.entrySet().stream().
			sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
		*/ 
		 map1.entrySet().stream().
		 sorted((a,b) -> (int)a.getKey().getSalary() - (int)b.getKey().getSalary()).forEach(System.out::println);
				
		
		//map2.forEach((k,v) -> System.out.println(k+" : "+v));
		//System.out.println(map2);
		
		
		
	}

}
