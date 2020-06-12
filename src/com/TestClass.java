package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		empList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		empList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		empList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		empList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		empList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		empList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		empList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		empList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		empList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		empList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		empList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		empList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		empList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		empList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		empList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		empList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		
		//How many male and female employees are there in the organization?
		Map<String, Long> collectResult1 = empList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
		System.out.println("How many male and female employees are there in the organization? \n" + collectResult1);
		
		//Print the name of all departments in the organization?
		System.out.println("\nPrint the name of all departments in the organization?");
		empList.stream().map(Employee :: getDepartment).distinct().forEach(System.out :: println);
		
		//What is the average age of male and female employees
		Map<String, Double> collectResult2 = empList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getAge)));
		System.out.println("\nWhat is the average age of male and female employees \n" + collectResult2);
		
		//Get the details of highest paid employee in the organization
		Optional<Employee> collectResult3 = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee :: getSalary)));
		System.out.println("\nGet the details of highest paid employee in the organization \n" + collectResult3);
		
		//Get the names of all employees who have joined after 2015
		System.out.println("\nGet the names of all employees who have joined after 2015");
		empList.stream().filter(emp -> emp.getYearOfJoining() > 2015).map(Employee :: getName).forEach(System.out :: println);
		
		//Count the number of employees in each department
		System.out.println("\nCount the number of employees in each department");
		Map<String, Long> collectResult4 = empList.stream().collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
		System.out.println(collectResult4);
		
		//What is the average salary of each department
		System.out.println("\nWhat is the average salary of each department");
		Map<String, Double> collectResult5 = empList.stream().collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.averagingDouble(Employee :: getSalary)));
		System.out.println(collectResult5);
		
		//Get the details of youngest male employee in the product development department
		System.out.println("\nGet the details of youngest male employee in the product development department");
		Optional<Employee> collectResult6 = empList.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("Product Development")).collect(Collectors.minBy(Comparator.comparingLong(Employee :: getAge)));
		System.out.println(collectResult6);
		
		//Who has the most working experience in the organization
		System.out.println("\nWho has the most working experience in the organization");
		Optional<Employee> collectResult7 = empList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee :: getYearOfJoining)));
		System.out.println(collectResult7.get().getName());
		
		//How many male and female employees are there in the sales and marketing team
		System.out.println("\nHow many male and female employees are there in the sales and marketing team");
		Map<String, Long> collectResult8 = empList.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
		System.out.println(collectResult8);
		
		//What is the average salary of male and female employees
		System.out.println("\nWhat is the average salary of male and female employees");
		Map<String, Double> collectResult9 = empList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getSalary)));
		System.out.println(collectResult9);
		
		//List down the names of all employees in each department
		System.out.println("\nList down the names of all employees in each department");
		Map<String, List<Employee>> collectResult10 = empList.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
		for(Entry<String, List<Employee>> entry : collectResult10.entrySet()) {
			System.out.println("::	" + entry.getKey() + "	::");
			for(Employee employee : entry.getValue()) {
				System.out.println(employee.getName());
			}
			System.out.println();
		}
		
		//What is the average salary and total salary of the whole organization
		System.out.println("\nWhat is the average salary and total salary of the whole organization");
		DoubleSummaryStatistics collectResult11 = empList.stream().collect(Collectors.summarizingDouble(Employee :: getSalary));
		System.out.println("Average Salary :: " + collectResult11.getAverage());
		System.out.println("Total Salary :: " + collectResult11.getSum());
		
		//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
		System.out.println("\nSeparate the employees who are younger or equal to 25 years from those employees who are older than 25 years");
		Map<Boolean, List<Employee>> collectResult12 = empList.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() > 25));
		for(Entry<Boolean, List<Employee>> entry : collectResult12.entrySet()) {
			System.out.println("::	" + (entry.getKey() == true ? "Employees older than 25 years" : "Employees younger than 25 years") + "	::");
			for(Employee employee : entry.getValue()) {
				System.out.println(employee.getName());
			}
			System.out.println();
		}
		
		//Who is the oldest employee in the organization? What is his age and which department he belongs to
		System.out.println("\nWho is the oldest employee in the organization? What is his age and which department he belongs to");
		Optional<Employee> max = empList.stream().max(Comparator.comparingInt(Employee :: getAge));
		System.out.println(max.get().getName() + " " + max.get().getAge() + " " + max.get().getDepartment());
		
		
		
		
		
		
		
	}

}
