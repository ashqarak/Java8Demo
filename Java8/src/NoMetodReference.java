import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class NoMetodReference {
	
	
	
	public static void formatAndPrint(BiFunction<String, List<String>, String> formattor, String delimeter,
			List<String> list) {
		String formatted = formattor.apply(delimeter, list);
		System.out.println(formatted);
	}
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ashqar", "Ali", "Khan");
		
		formatAndPrint(String::join, ", ", names);
			
		}

	}


 