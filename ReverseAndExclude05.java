import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int digit = Integer.parseInt(scanner.nextLine());
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));
        Predicate<Integer> nonDivisible = element -> element % digit != 0;

        numbers = numbers.stream().filter(a -> nonDivisible.test(a)).collect(Collectors.toList());
        Collections.reverse(numbers);

        print.accept(numbers);
    }
}
