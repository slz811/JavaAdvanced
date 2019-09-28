import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(tokens[0]).forEach(stack::push);

        for (int i = 0; i < tokens[1]; i++) {
            stack.pop();
        }

        boolean isPresent = false;
        if (stack.contains(tokens[2])) {
            isPresent = true;
        }

        int minValue = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current < minValue) {
                minValue = current;
            }
        }


        if (isPresent) {
            System.out.println("true");
        } else {
            if (minValue < Integer.MAX_VALUE) {
                System.out.println(minValue);
            } else {
                System.out.println(0);
            }
        }

    }
}
