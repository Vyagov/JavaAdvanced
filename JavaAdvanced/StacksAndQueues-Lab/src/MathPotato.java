import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] child = scanner.nextLine().split("\\s");
        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<Integer> queuePrime = new ArrayDeque<>();

        Collections.addAll(queue, child);

        for (int i = 2; i <= count * 3; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                queuePrime.offer(i);
            }
        }
        int cycle = 1;

        while (queue.size() > 1) {
            for (int k = 1; k < count; k++) {
                queue.offer(queue.poll());
            }
            if (cycle == queuePrime.peek()) {
                System.out.println("Prime " + queue.peek());
                queuePrime.poll();
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
