package Java8.Lamda;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 *
 * @author Codex Coffee
 */
public class lamda {
    public static void main(String[] args) throws IOException {


            IntSummaryStatistics statistis = IntStream.of(5,3,5,2,5,1,5,34,53,2,3).summaryStatistics();
            System.out.println("Max is : " + statistis.getMax());
            System.out.println("Min is : " + statistis.getMin());
            System.out.println("Sum is : " + statistis.getSum());
            System.out.println("Total Count is : " + statistis.getCount());
          
    }
}
