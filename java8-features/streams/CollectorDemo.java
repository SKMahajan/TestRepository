package streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {

	public static void main(String[] args) {
		List<Person1> people = new ArrayList<Person1>();
		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(CollectorDemo.class.getResourceAsStream("people.txt")));
				Stream<String> stream = reader.lines();
				){
			stream.map(l->{
				String[] s=l.split(" ");
				Person1 p = new Person1(Integer.parseInt(s[1]), s[0].trim());
				people.add(p);
				return p;
			})
					.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("people with age >20");
		Stream<Person1> stream = people.stream();
		Optional<Person1> op = stream
			.filter(e->e.getAge()>20)
			.min(Comparator.comparing(Person1::getAge));
		System.out.println(op);
		
		op = people.stream()
				.max(Comparator.comparing(Person1::getAge));
			System.out.println(op);
		
		Map<Integer, List<Person1>> map = 
				people.stream()
					.collect(Collectors.groupingBy(
							Person1::getAge
					));
		System.out.println("list of people by their age");
		System.out.println(map);
		Map<Integer, Long> map1 = people.stream()
					.collect(Collectors.groupingBy(
							Person1::getAge,
							Collectors.counting()
					));
		System.out.println("count of people by their age");
		System.out.println(map1);
		
		Map<Integer, List<String>> map2 = 
				people.stream()
					.collect(Collectors.groupingBy(
							Person1::getAge,
							Collectors.mapping(
									Person1::getName,
									Collectors.toList()
									//Collectors.toCollection(TreeSet::new)
							)
					));
		System.out.println("name of people by their age");
		System.out.println(map2);
				
		Map<Integer, Set<String>> map3 = 
				people.stream()
					.collect(Collectors.groupingBy(
							Person1::getAge,
							Collectors.mapping(
									Person1::getName,
									Collectors.toCollection(TreeSet::new)
							)
					));
		System.out.println("name of people in alphabetical order by their age");
		System.out.println(map3);
			
	}

}
class Person1{
	private int age;
	private String name;
	public Person1() {
		super();
	}
	public Person1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person1 [age=" + age + ", name=" + name + "]";
	}
	
}