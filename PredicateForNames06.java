import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> namesPredicate = str -> str.length() <= length;

        Consumer<List<String>> print = list -> list.forEach(System.out::println);

        names = names.stream().filter(name -> namesPredicate.test(name)).collect(Collectors.toList());

        print.accept(names);
    }
}
