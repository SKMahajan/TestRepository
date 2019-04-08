package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapDemo {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,2,3);
		List<Integer> list3 = Arrays.asList(1,2);
		List<List<Integer>> list = Arrays.asList(list1,list2,list3);
		System.out.println(list);
		list.stream()
			.map(l->l.size())
			.forEach(System.out::println);
		
		//using function as a parameter in map()
		Function<List<?>, Integer> size = List::size;
		System.out.println("using function as a parameter in map()");
		list.stream()
		.map(size)
		.forEach(System.out::println);
		
		//using stream of stream in map()
		Function<List<Integer>, Stream<Integer>> flatmapper = l->l.stream();
		System.out.println("using stream of stream in map()");
		list.stream()
			.map(flatmapper)
			.forEach(System.out::println);
		
		//using stream of stream in flatmap()
		System.out.println("using stream of stream in flatmap()");
		list.stream()
			.flatMap(flatmapper)
			.forEach(System.out::println);
	}

}
