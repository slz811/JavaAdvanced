import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Party!".equals(line)) {
            String command = line.substring(0, line.indexOf(" ")); //ex.: Remove
            String predicateName = line.substring(line.indexOf(" ") + 1); //ex.: StartsWith P

            if (command.equalsIgnoreCase("Remove")) {
                names.removeIf(getPredicate(predicateName));
            } else {
                List<String> doubledNames = names.stream().filter(getPredicate(predicateName))
                        .collect(Collectors.toList());

                names.addAll(doubledNames);
            }


            line = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.stream().sorted(String::compareTo).collect(Collectors.joining(", ")) + " are going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String predicateName) {
        String[] tokens = predicateName.split("\\s");
        String type = tokens[0];
        String param = tokens[1];

        Predicate<String> predicate = null;
        if (type.equalsIgnoreCase("StartsWith")) {
            predicate = name -> name.startsWith(param);

        } else if (type.equalsIgnoreCase("EndsWith")) {
            predicate = name -> name.endsWith(param);

        } else if (type.equalsIgnoreCase("Length")) {
            predicate = name -> name.length() == Integer.parseInt(param);

        }

        return predicate;
    }
}
