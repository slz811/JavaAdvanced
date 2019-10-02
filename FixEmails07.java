import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsBook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            emailsBook.put(name, email);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emailsBook.entrySet()) {
            String email = entry.getValue();
            if (email.substring(email.lastIndexOf(".") + 1, email.length()).equals("bg")) {
                System.out.printf("%s -> %s%n", entry.getKey(), email);
            }
        }
    }
}
