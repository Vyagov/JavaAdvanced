import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input;

        while (!"Home".equalsIgnoreCase(input = scanner.nextLine())) {
            if (!"back".equalsIgnoreCase(input) && !"forward".equalsIgnoreCase(input)) {
                stack.push(input);
                System.out.println(input);
            }
            if ("back".equalsIgnoreCase(input)) {
                if (stack.size() > 1) {
                    queue.offer(stack.pop());
                    System.out.println(stack.peek());
                }
            }
            if ("forward".equalsIgnoreCase(input)) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    stack.push(queue.poll());
                    System.out.println(stack.peek());
                }
            }
        }
    }
}