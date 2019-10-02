import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mines = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            mines.putIfAbsent(name, 0);
            mines.put(name, mines.get(name) + quantity);

            input = scanner.nextLine();
        }

        mines.forEach((key, value) -> {
            System.out.printf("%s -> %d%n", key, value);
        });
    }
}