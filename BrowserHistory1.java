package JavaOOP;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            boolean error = false;
            if (input.equals("back")) {
                if (historyStack.size() < 2) {
                    error = true;
                    System.out.println("no previous URLs");
                } else {
                    historyStack.pop();
                }
            } else {
                historyStack.push(input);
            }

            if (!error) {
                System.out.println(historyStack.peek());
            }

            input = scanner.nextLine();
        }

    }
}
