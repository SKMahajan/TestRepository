package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ForEachDemo {

	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("name1", 65, 86564));
		pList.add(new Person("name4", 45, 8656));
		pList.add(new Person("name2", 25, 865));
		
		List<Person> otherList = new ArrayList<>();
		
		//using lambda expression
		System.out.println("using lambda expression");
		pList.stream().forEach(e->System.out.println(e));
		//using method reference
		System.out.println("using method reference");
		pList.stream().forEach(System.out::println);
		
		System.out.println("using map, filter and forEach");
		pList.stream()
			.map(e->e.age)
			.filter(e->e<50)
			.forEach(System.out::println);
		
		//Stream building
		//consumer chaining
		System.out.println("Using consumer chaining");
		Consumer<Person> c1 = otherList::add;
		Consumer<Person> c2 = System.out::println;
		Consumer<Person> c3 = c1.andThen(c2);
		pList.stream()
			.forEach(c3);
		
		//filter()
		System.out.println("Using predicate in filter method - and, or, negate");
		Predicate<Person> p1 = e->e.age<50;
		Predicate<Person> p2 = e->e.age>25;
		Predicate<Person> p3 = e->e.age==45;
		//Predicate<Person> p = p1.and(p2).or(p3);
		Predicate<Person> p = p1.and(p2).negate();
		pList.stream()
			.filter(p)
			.forEach(System.out::println);
		
		System.out.println("Using predicate in filter method - isEqual");
		Predicate<String> p4 = Predicate.isEqual("name1");
		Stream<String> stream = Stream.of("name1","name2","name3");
		stream.filter(p4)
			.forEach(System.out::println);
		
		
		
		System.out.println("using peek() method");
		Predicate<Person> p5 = e->e.equals(new Person("name1", 65, 86564));
		otherList=new ArrayList<>();
		pList.stream()
			.peek(System.out::println)
			.filter(p5)
			.forEach(otherList::add);
		System.out.println("size : " +otherList.size());
		
	}

}

class Person{
	String name;
	int age;
	int pan;
	
	public Person() {}
	
	public Person(String name, int age, int pan) {
		super();
		this.name = name;
		this.age = age;
		this.pan = pan;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPan() {
		return pan;
	}
	public void setPan(int pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pan=" + pan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pan;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pan != other.pan)
			return false;
		return true;
	}
	
}
