import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class RoboticSss {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();

        String[] robsWithTime = reader.readLine().split(";");

        String[] robots = new String[robsWithTime.length]; // instead of Map
        int[] times = new int[robsWithTime.length]; // instead of Map

        int[] processTimes = new int[robsWithTime.length];

        int index = 0;
        for (String robot : robsWithTime) {
            String[] data = robot.split("-");
            robots[index] = data[0];
            times[index] = Integer.parseInt(data[1]);
            index++;
        }

        int[] timeData = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int beginSeconds = timeData[0] * 3600 + timeData[1] * 60 + timeData[2];

        ArrayDeque<String> queue = new ArrayDeque<>();

        String line = reader.readLine();
        while (!line.equals("End")) {
            queue.offer(line);

            line = reader.readLine();
        }


        while (!queue.isEmpty()) {
            beginSeconds++;
            String product = queue.poll();

            for (int i = 0; i < processTimes.length; i++) {
              if (processTimes[i]>0){
                  processTimes[i]--;
              }
            }

            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTimes[i] == 0) {
                    processTimes[i] = times[i];
                    builder.append(print(robots[i], product, beginSeconds));
                    isTaken = true;
                    break;
                }
   
            }
            if (!isTaken) {
                queue.offer(product);
            }

        }
        System.out.println(builder.toString());

    }

    private static String print(String robot, String product, long beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;
        return String.format("%s - %s [%02d:%02d:%02d]%n", robot, product, h, m, s);
    }
}
