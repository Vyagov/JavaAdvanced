import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = "";

        while (numberOfOperations-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "1":
                    stack.push(text);
                    text += commands[1];
                    break;
                case "2":
                    stack.push(text);
                    int lastChars = Integer.parseInt(commands[1]);
                    text = text.substring(0, text.length() - lastChars);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}
