import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		
		//Arrays.asList(1,2,3,4,5,6).forEach((i) -> System.out.println(i));
		/*
		 * Arrays.asList(1,1,2,2,3,3,4,4).stream(). distinct(). skip(2).
		 * forEach(System.out::println);
		 */
		
		/*
		 * Arrays.stream(new int[] {1,2,3,4}).map(x ->
		 * x*x).average().ifPresent(System.out::println);
		 * 
		 * String s = "abcaba"; Map<Character, Integer> freqs = new HashMap<>(); for
		 * (char c : s.toCharArray()) { freqs.merge(c, // key = char 1, // value to
		 * merge Integer::sum); // counting } System.out.println("Frequencies:\n" +
		 * freqs);
		 */
		
		String str = "Ashqar Ali Khan AKHAN";
		List<String> employees = new ArrayList<String>();
		employees.add("Ashqar");
		employees.add("Ali");
		
		//starts with a and sort
		List<String> list1 = Arrays.asList(str.split(" "));
		list1.stream().filter(s -> s.startsWith("A")).sorted((a,b) -> a.compareTo(b)).
		collect(Collectors.toList()).forEach(System.out::println);
		
		//count number of occurences
		Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((k,v) -> {
			System.out.println(k +" : "+v);
		});
		
		Map<Object, Long> map1 = employees.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		map1.forEach((k,v) -> {
			System.out.println(k +" : "+v);
		});
		
		
		
	}

}

interface ComputableType<T> {
    T compute(T x);
}