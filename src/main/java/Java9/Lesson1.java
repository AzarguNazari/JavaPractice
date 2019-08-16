package Java9;

import java.util.Arrays;
import java.util.List;

interface Util{
	void doit();
	default void doSomethingElseToo() {
		privateOperation();
		System.out.println("Here is another thing to do ");
	}
	private void privateOperation() {
		System.out.println("Operation Dependencies");
	}
}

public class Lesson1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Util it = () -> System.out.println("Hello World");
//		it.doit();
//		it.doSomethingElseToo();
		
		List<Integer> numbers = Arrays.asList(11,2,42,534,1,23,5,34,5,34,22);
		
		// break the look while the condition is met
//		numbers.stream().takeWhile(num -> num > 10).forEach(System.out::println);
		
		numbers.stream().dropWhile(num -> num % 2 == 0).forEach(System.out::println);
		
	}

}
