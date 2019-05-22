import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfElementsToPush = commands[0];
        int numberOfElementsToPop = commands[1];
        int isPresentInStack = commands[2];

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numberOfElementsToPush)
                .mapToInt(Integer::parseInt)
                .forEach(stackOfNumbers::push);

        while (numberOfElementsToPop-- > 0) {
            stackOfNumbers.pop();
        }

        if (stackOfNumbers.isEmpty()) {
            System.out.println(0);
        } else if (stackOfNumbers.contains(isPresentInStack)) {
            System.out.println("true");
        } else {
            int minElem = stackOfNumbers.pop();

            while (!stackOfNumbers.isEmpty()) {
                int currentElem = stackOfNumbers.pop();

                if (minElem > currentElem) {
                    minElem = currentElem;
                }
            }
            System.out.println(minElem);
        }
    }
}
