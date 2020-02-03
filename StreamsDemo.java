import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4);
        HashMap<Integer, Integer> map;
        List<Integer> list = number.stream()
                .filter(n -> n > 2)
                .map(t -> t*t)
                .collect(Collectors.toList());

        System.out.println(list);


    }


}
