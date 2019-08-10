package Lab2InnerClasses;

import java.util.ArrayList;
import java.util.Iterator;

public class Factorial implements Iterable<Long>{
    
    private ArrayList<Long> iterators;
    
    public Factorial(int lowerLimit, int upperLimit){
       iterators = new ArrayList<>();
        class findingFactorial{
            public Long factorial(int number){
               if(number < 1) throw new IllegalArgumentException("Sorry you need to enter positive number");
               if(number == 2L) return 1L;
               return number * factorial(number - 1);
            }
        }
       findingFactorial temp = new findingFactorial();
       while(lowerLimit++ < upperLimit){
          iterators.add(temp.factorial(lowerLimit));
       }
    }
    
    

    @Override
    public Iterator<Long> iterator() {
        return iterators.iterator();
    }

    public static void main(String[] args) {
        
        Factorial f = new Factorial(10, 20);
        
        print(f.iterator());
        
    }
    
    public static void print(Iterator<Long> numbers){
        System.out.println("The Factorials");
        while(numbers.hasNext()){
            System.out.println(numbers.next());
        }
    }
    
}
