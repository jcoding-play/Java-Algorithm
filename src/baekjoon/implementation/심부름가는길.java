package baekjoon.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 심부름가는길 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> seconds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            seconds.add(scanner.nextInt());
        }

        Time time = new Time(seconds);

        System.out.printf("%d\n%d", time.getMinute(), time.getSecond());
    }

    static class Time {
        private final int minute;
        private final int second;

        public Time(List<Integer> seconds) {
            int totalSeconds = calculateTotalSeconds(seconds);

            this.minute = totalSeconds / 60;
            this.second = totalSeconds % 60;
        }

        private int calculateTotalSeconds(List<Integer> seconds) {
            return seconds.stream()
                    .reduce(0, Integer::sum);
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }
    }
}
