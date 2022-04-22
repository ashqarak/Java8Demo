package com.util.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
	
	public static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 15000.0));
		employeeList.add(new Employee(112, "Paul Sharma", 31, "Male", "Marketing", 2012, 25000.0));
		employeeList.add(new Employee(113, "Martin Ricky", 23, "Male", "Product Development", 2013, 35000.0));
		employeeList.add(new Employee(114, "Murali Den", 10, "Male", "Account and Finance", 2014, 45000.0));
		employeeList.add(new Employee(115, "Nima Sharma", 34, "Female", "Marketing", 2015, 55000.0));
		employeeList.add(new Employee(116, "Iqbal Hussain", 56, "Male", "Infrastructure", 2016, 65000.0));
		employeeList.add(new Employee(117, "Manu Roy", 40, "Female", "HR", 2017, 75000.0));
		employeeList.add(new Employee(118, "Wang Gonda", 24, "Male", "Marketing", 2018, 85000.0));
		employeeList.add(new Employee(119, "Amelia Theron", 42, "Female", "Account and Finance", 2019, 95000.0));
		employeeList.add(new Employee(120, "Amanda Cerny", 45, "Female", "Infrastructure", 2020, 105000.0));
		employeeList.add(new Employee(121, "Ronaldo", 37, "Male", "Infrastructure", 2021, 1050000.0));
		
		//male and female employees in organisation
		System.out.println("1 ->");
		Map<String, Long> map1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		map1.forEach((k,v)-> System.out.println(k+" : "+v));
		System.out.println();
		
		
		//print the name of all departments in the organisation
		System.out.println("2 ->");
		employeeList.stream().map(Employee::getDepartment).forEach(System.out::println);
		System.out.println();
		
		//average age of male and female employees
		System.out.println("3 ->");
		Map<String, Double> map2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		map2.forEach((k,v)-> System.out.println(k+" : "+v));
		System.out.println();
		
		//highest paid employee in the organization
		System.out.println("4 ->");
		Optional<Employee> emp1 = employeeList.stream().sorted((e1,e2) -> (int)e2.getSalary() - (int)e1.getSalary()).findFirst();
		//OR
		Optional<Employee> emp2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println();
		
		//get the names of all employees who have joined after 2015
		System.out.println("5 ->");
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		System.out.println();
		
		//count the number of employees in each department
		System.out.println("6 ->");
		Map<String, Long> map3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		map3.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println();
		
		//what is the average salary of each department
		System.out.println("7 ->");
		Map<String, Double> map4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		map4.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println();
		
		//get the details of youngest female employee in the HR department
		System.out.println("8 ->");
		Optional<Employee> opt = employeeList.stream().filter(e-> e.getGender().equals("Female") && e.getDepartment().equals("HR")).min(Comparator.comparing(Employee::getAge));
		System.out.println("Youngest Employee : "+opt.get());
		//OR
		Optional<Employee> opt1 = employeeList.stream().filter(e-> e.getGender().equals("Female") && e.getDepartment().equals("HR")).
				sorted((e1,e2) -> e1.getAge() - e2.getAge()).findFirst();
		System.out.println("Youngest Employee : "+opt1.get());
		System.out.println();
		
		//who has the most working experience in the department
		System.out.println("9 ->");
		Optional<Employee> experienceEmployee = employeeList.stream().
					sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		System.out.println(experienceEmployee.get());
		System.out.println();
		
		// how many male and female employees are there in the Marketing department
		System.out.println("10 ->");
		Map<String, Long> map5 = employeeList.stream().filter(e -> e.getDepartment().equals("Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		map5.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println();
		
		// what is the average salary of male and female employees
		System.out.println("11 ->");
		Map<String, Double> map6 = employeeList.stream().
			collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		map6.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println();
		
		//list down the name of all employees in each department
		System.out.println("12 ->");
		Map<String, List<Employee>> map7 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> map7set = map7.entrySet();
		for(Entry<String, List<Employee>> entry : map7set) {
			System.out.println();
			System.out.println("Department : " +entry.getKey());
			List<Employee> list = entry.getValue();
			for(Employee e : list) {
				System.out.println(e.getName());
			}
		} 
		System.out.println();
		
		//what is the average salary and total salary of whole organization
		System.out.println("13 ->");
		DoubleSummaryStatistics salary =  employeeList.stream().
				collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Total Salary : "+salary.getSum());
		System.out.println("Average Salary : "+salary.getAverage());
		System.out.println();
		
		//separate the employees who are younger or equal to 25 years from those who are older than 25 years
		System.out.println("14 ->");
		Map<Boolean, List<Employee>> map8 = employeeList.stream().
				collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		map8.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println();
		
		// who is the oldest employee in the organization ? what is his age and which department he belongs to ?
		System.out.println("15 ->");
		Optional<Employee> employee = employeeList.stream().
				max(Comparator.comparing(Employee::getAge));
		System.out.println("Employee : "+employee.get().getName());
		System.out.println("Age : "+employee.get().getAge());
		System.out.println("Department : "+employee.get().getDepartment());
		
	}
	

}
