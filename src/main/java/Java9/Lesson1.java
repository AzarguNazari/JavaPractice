package Java9;

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

		Util it = () -> System.out.println("Hello World");
		it.doit();
		it.doSomethingElseToo();
		
	}

}
