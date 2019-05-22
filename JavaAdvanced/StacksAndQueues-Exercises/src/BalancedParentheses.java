import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean areBalanced = false;

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.length() % 2 != 0) {
                break;
            }
            char symbol = parentheses.charAt(i);

            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            } else {
                char lastSymbol = stack.pop();

                if ((lastSymbol == '(' && symbol == ')') ||
                        (lastSymbol == '[' && symbol == ']') ||
                        (lastSymbol == '{' && symbol == '}')) {
                    areBalanced = true;
                } else {
                    break;
                }
            }
        }
        System.out.println(areBalanced ? "YES" : "NO");
    }
}
