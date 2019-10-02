import java.util.*;
import java.util.stream.Collectors;


public class HandsOfCards08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            List<String> deck = Arrays.stream(tokens[1].split(",\\s+")).collect(Collectors.toList());

            players.putIfAbsent(name, new HashSet<>());
            players.get(name).addAll(deck);

            input = scanner.nextLine();
        }

        players.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, getTotalPower(value));
        });

    }

    private static int getTotalPower(Set<String> cards) {
        int totalPower = 0;
        for (String card : cards) {
            totalPower += getCardPower(card);
        }
        return totalPower;
    }

    private static int getCardPower(String card) {
        int cardPower = 0;

        char firstChar = card.charAt(0);

        switch (firstChar) {
            case '1':
                cardPower += 10;
                break;
            case 'J':
                cardPower += 11;
                break;
            case 'Q':
                cardPower += 12;
                break;
            case 'K':
                cardPower += 13;
                break;
            case 'A':
                cardPower += 14;
                break;
            default:
                cardPower += firstChar - '0';
                break;
        }

        char lastChar = card.charAt(card.length() - 1);

        switch (lastChar) {
            case 'S':
                cardPower *= 4;
                break;
            case 'H':
                cardPower *= 3;
                break;
            case 'D':
                cardPower *= 2;
                break;

        }

        return cardPower;
    }
}