import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        numbers.stream().sorted((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        }).forEach(e -> System.out.print(e + " "));

    }
}