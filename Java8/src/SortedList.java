import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Ashqar" , 30, 35000));
		list.add(new Employee(2, "Ali", 40, 15000));
		list.add(new Employee(3, "Khan", 50, 25000));
		list.add(new Employee(4, "Sahil", 20, 45000));
		Collections.sort(list, Comparator.comparing(Employee::getSalary) );
		
		System.out.println(list);
	}

}

