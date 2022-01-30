import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class LinearSearch {
    public static void main(String[] args) {
        var number = 3;
        int[] array = {0,7,5,0,8,3,0,33};
        streamExample();

//        boolean res = isPresent(number, array);
//        System.out.println(res);

    }

    public static boolean streamExample() {
        var namesList = Arrays.asList("John", "Marry", "George", "Paul", "Alice", "Ann");
        namesList.stream()
                .filter(name -> { System.out.println("filter: " + name
                        .startsWith("A"));
                return true;})
                .forEach(name -> {
                    System.out.println("forEach: " + name);
                });
    return true;}
//    static boolean isPresent(int number, int[] array){
//        return Arrays.stream(array)
//                .filter( n -> n == number)
//                .collect
//    }
}
