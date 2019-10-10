import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TheSmallestElementIndex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> theSmallestElement = numbers -> numbers.stream().min(Integer::compareTo).get();

        System.out.println(numbersInput.lastIndexOf(theSmallestElement.apply(numbersInput)));

    }
}
