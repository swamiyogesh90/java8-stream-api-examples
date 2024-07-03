package javaFunctions;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.Employee;

public class TestFunction {
	
	public static Supplier<Employee> getEmp = () -> new Employee(1, "Last_Name, First_Name", 34, "Male", "IT Finance", 2011, 34000.0);
	
	public static Consumer<Employee> printEmp = (emp) -> System.out.println("Consumer :: " + emp);
	
	public static Function<Employee, String> empName = emp -> emp.getName();
	
	public static BiFunction<Employee, String, String> updatedName = (emp, appender) -> emp.getName() + appender;
	
	public static Predicate<Employee> isMaleEmp = emp -> emp.getGender().equalsIgnoreCase("male");

	public static void main(String[] args) {
		
		System.out.println("Supplier :: " + getEmp.get());
		printEmp.accept(getEmp.get());
		System.out.println("Function :: " + empName.apply(getEmp.get()));
		System.out.println("BiFunction :: " + updatedName.apply(getEmp.get(), " updated"));
		System.out.println("Predicate :: " + isMaleEmp.test(getEmp.get()));

	}

}
