import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueOfNumbers = new ArrayDeque<>();

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfElementsToOffer = commands[0];
        int numberOfElementsToPoll = commands[1];
        int isPresentInStack = commands[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numberOfElementsToOffer)
                .mapToInt(Integer::parseInt)
                .forEach(queueOfNumbers::offer);

        while (numberOfElementsToPoll-- > 0) {
            queueOfNumbers.poll();
        }

        if (queueOfNumbers.isEmpty()) {
            System.out.println(0);
        } else if (queueOfNumbers.contains(isPresentInStack)) {
            System.out.println("true");
        } else {
            int minElem = queueOfNumbers.poll();

            while (!queueOfNumbers.isEmpty()) {
                int currentElem = queueOfNumbers.poll();

                if (minElem > currentElem) {
                    minElem = currentElem;
                }
            }
            System.out.println(minElem);
        }
    }
}
