package innerClasses;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class University {

    class engineringFaculty{
        String name = "Engineering";
        
    }
    
    class computingFaculty{
        String name= "COmputer Science";
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, IOException {

    }

    public void calculate(Map<Integer, Integer> map) {
        class Cal {

            void perform(int a, int b) {
                System.out.println(a * b);
            }
        }
        Iterator it = map.entrySet().iterator();
        Cal c = new Cal();
        Entry<Integer, Integer> i;
        while (it.hasNext()) {
            i = (Entry<Integer, Integer>) it.next();
            c.perform(i.getKey(), i.getValue());
        }
    }

}

class TopClass {

    // public protected private
    private class innerClass {
        // this is member class
    }

    public class innerPublic {

        public innerPublic() {
        }

        public void doit() {
            System.out.println("Hello world");
        }
    }

    public static class innerStatic {
        // inner clss static
    }

    public void perform() {
        class localClass {

            TopClass t = new TopClass() {
                // annonymous inner class
            };
        }
    }
}

class TitleList {

    private ArrayList<String> titleList = new ArrayList<>();

    public void addTitle(String title) {
        titleList.add(title);
    }

    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
// A local inner class - TitleIterator
        class TitleIterator implements Iterator<String> {

            int count = 0;

            @Override
            public boolean hasNext() {
                return (count < titleList.size());
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        } // Local Inner Class TitleIterator ends here
// Create an object of the local inner class and return the reference
        TitleIterator titleIterator = new TitleIterator();
        return titleIterator;
    }
}
