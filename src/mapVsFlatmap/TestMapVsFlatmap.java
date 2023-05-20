package mapVsFlatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapVsFlatmap {

	public static void main(String[] args) {
		
		//map function
		getAllCustomerDetails().stream().map(cust -> cust.getName()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		
		getAllCustomerDetails().stream().map(cust -> cust.getPhoneNumbers()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		
		//flatMap
		getAllCustomerDetails().stream().flatMap(cust -> cust.getPhoneNumbers().stream()).collect(Collectors.toList()).forEach(System.out::println);

	}
	
	public static List<Customer> getAllCustomerDetails() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

}
