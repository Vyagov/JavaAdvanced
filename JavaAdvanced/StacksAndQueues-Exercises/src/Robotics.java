import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robotsName = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");

            robotsName[i] = data[0];
            processTime[i] = Integer.parseInt(data[1]);
        }

        String startTime = scanner.nextLine();

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        LocalTime time = LocalTime.of(hours, minutes, seconds);

        ArrayDeque<String> queueOfProducts = new ArrayDeque<>();

        String inputProduct;

        while (!"End".equalsIgnoreCase(inputProduct = scanner.nextLine())) {
            queueOfProducts.offer(inputProduct);
        }
        while (!queueOfProducts.isEmpty()) {
            time = time.plusSeconds(1);

            String product = queueOfProducts.poll();
            boolean isAssigned = false;

            for (int i = 0; i < workTime.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = processTime[i];
                    isAssigned = true;

                    printRobotData(robotsName[i], product, time);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isAssigned) {
                queueOfProducts.offer(product);
            }
        }
    }

    private static void printRobotData(String robotName, String product, LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(String.format("%s - %s [%s]", robotName, product, time.format(formatter)));
    }
}
