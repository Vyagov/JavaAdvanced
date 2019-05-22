import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expression = scanner.nextLine().split("\\s");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, expression);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if ("+".equals(operator)) {
                stack.push((firstNum + secondNum) + "");
            } else if ("-".equals(operator)) {
                stack.push((firstNum - secondNum) + "");
            }
        }
        System.out.println(stack.pop());
    }
}
