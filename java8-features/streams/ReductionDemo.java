package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,10,10);
		Integer sum = 
				list.stream()
					.reduce(0, Integer::sum);
		System.out.println("Sum : "+sum);
		
		//for empty list, sum should be identity element
		List<Integer> list1 = Arrays.asList();
		Integer sumIdentity = 
				list1.stream()
					.reduce(0, Integer::sum);
		System.out.println("Sum : "+sumIdentity);
		
		//reduction using Optional object
		Optional<Integer> max = 
				list.stream()
					.reduce(Integer::max);
		System.out.println("max : "+max);
		
		max = list1.stream()
					.reduce(Integer::max);
		System.out.println("max for empty stream : "+max);
		
	}

}
