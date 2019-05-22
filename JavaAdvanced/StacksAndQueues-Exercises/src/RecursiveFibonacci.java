import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        memory = new long[num + 1];

        long result = getFibonacci(num);

        System.out.println(result);
    }

    private static long getFibonacci(int num) {
        if (num < 2) {
            return 1;
        }
        if (memory[num] != 0) {
            return memory[num];
        }

        return memory[num] = getFibonacci(num - 1) + getFibonacci(num - 2);
    }
}
