import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParanthesses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();


        String input = scanner.nextLine();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()){
                    isBalanced=false;
                    break;
                }
                char last = stack.pop();
                if (last == '(' && symbol != ')') {
                    isBalanced = false;
                    break;
                } else if (last == '{' && symbol != '}') {
                    isBalanced = false;
                    break;
                } else if (last == '[' && symbol != ']') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
