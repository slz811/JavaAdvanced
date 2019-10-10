import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Integer> printer = number -> System.out.print(number + " ");

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Predicate<Integer> tester = e -> {
            for (Integer number : numbers) {
                if (e % number != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (tester.test(i)) {
                printer.accept(i);
            }

        }

    }
}