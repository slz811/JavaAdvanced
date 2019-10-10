import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> findMinElementInArray = arr -> Arrays.stream(arr).min().orElse(0);

        System.out.println(findMinElementInArray.apply(array));


    }
}
