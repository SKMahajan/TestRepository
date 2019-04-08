package datetime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {

	public static void main(String[] args) {
		Comparator<Person2> comp = Comparator.comparing(Person2::getName)
				.thenComparing(Person2::getDateOfBirth);
		List<Person2> l = new ArrayList<>();
		l.add(new Person2("xyz", LocalDate.now().minusDays(3L)));
		l.add(new Person2("pqr", LocalDate.now().plusDays(2)));
		l.add(new Person2("abc", LocalDate.now()));
		l.add(new Person2("efg", LocalDate.now().minusDays(1L)));
		
		l.sort(comp);
		l.forEach(System.out::println);
		System.out.println("**************");
		l.sort(comp.reversed());
		l.forEach(System.out::println);
		System.out.println("**************");
		List<String> l1 = l.stream().map(e->e.getName()).collect(Collectors.toList());
		l1.sort(Comparator.naturalOrder());
		l1.forEach(System.out::println);
		System.out.println("**************");
		//consider null values less than or greater than non null values
		l.sort(Comparator.nullsFirst(comp));
		l.sort(Comparator.nullsLast(comp));
		l.forEach(System.out::println);
	}
}