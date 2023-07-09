package mapVsFlatmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BooksExample {

	public static void main(String[] args) {

		Developer d1 = new Developer();
		d1.setName("mkyong");
		d1.addBook("Java 8 in Action");
		d1.addBook("Spring Boot in Action");
		d1.addBook("Effective Java (3nd Edition)");

		Developer d2 = new Developer();
		d2.setName("zilap");
		d2.addBook("Learning Python, 5th Edition");
		d2.addBook("Effective Java (3nd Edition)");

		List<Developer> list = new ArrayList<>();
		list.add(d1);
		list.add(d2);
		
		//getUniqueBooksExceptPython
		list.stream().flatMap(d -> d.getBook().stream()).filter(d -> !d.contains("Python"))
		.collect(Collectors.toSet()).forEach(System.out::println);

	}

}

class Developer {

	private Integer id;
	private String name;
	private Set<String> book;

	// getters, setters, toString

	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

}
