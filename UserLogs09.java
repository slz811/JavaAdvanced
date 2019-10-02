import java.util.*;

public class UserLogs09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].substring(tokens[0].indexOf('=') + 1, tokens[0].length());
            String username = tokens[2].substring(tokens[2].indexOf('=') + 1, tokens[2].length());

            users.putIfAbsent(username, new LinkedHashMap<>());
            users.get(username).putIfAbsent(ip, 0);
            users.get(username).put(ip, users.get(username).get(ip) + 1);

            input = scanner.nextLine();
        }

        users.forEach((key, value) -> {
            System.out.println(key + ": ");
            List<String> values = new ArrayList<>();
            for (String ip : value.keySet()) {
                values.add(String.format("%s => %d", ip, value.get(ip)));
            }
            System.out.print(String.join(", ", values));
            System.out.print(".");
            System.out.println();
        });
    }
}
