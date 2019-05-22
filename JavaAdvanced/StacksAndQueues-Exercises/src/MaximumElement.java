import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        while (numberOfCommands-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "1":
                    int element = Integer.parseInt(commands[1]);
                    stackOfNumbers.push(element);
                    break;
                case "2":
                    stackOfNumbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stackOfNumbers));
                    break;
            }
        }
    }
}
