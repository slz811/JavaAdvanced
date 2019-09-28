import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] commands = reader.readLine().split(" ");
            String command = commands[0];

            switch (command) {
                case "4":
                    if (!stack.isEmpty()) {
                        builder.delete(0, builder.length()).append(stack.pop());
                    }
                    break;
                case "1":
                    stack.push(builder.toString());
                    builder.append(commands[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(commands[1]);
                    if (builder.length() >= count) {
                        stack.push(builder.toString());
                        builder.replace(builder.length() - count, builder.length() + 1, "");
                    }
                    break;
                case "3":

                    int index = Integer.parseInt(commands[1]) - 1;
                    if (index >= 0) {

                        System.out.println(builder.charAt(index));
                    }
                    break;
            }
        }

    }

}


