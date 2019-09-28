import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(scanner.nextLine().split("\\s+")).limit(nsx[0]).mapToInt(Integer::parseInt).forEach(queue::add);

        while (nsx[1]-- > 0) {
            queue.pop();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(nsx[2])) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }

    }
}
