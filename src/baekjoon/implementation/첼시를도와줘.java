package baekjoon.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 첼시를도와줘 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = Integer.parseInt(scanner.nextLine());

        run(testCase);
    }

    private static void run(int testCase) {
        Stream.generate(() -> readNumberOfPlayers())
                .limit(testCase)
                .map(numberOfPlayers -> initializePlayers(numberOfPlayers))
                .map(players -> players.findMaxSalaryPlayer())
                .forEach(player -> showMaxSalaryPlayerName(player));
    }

    private static int readNumberOfPlayers() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Players initializePlayers(int p) {
        return Stream.generate(() -> Player.from(scanner.nextLine()))
                .limit(p)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }

    private static void showMaxSalaryPlayerName(Player player) {
        System.out.println(player.getName());
    }

    static class Players {
        private final List<Player> players;

        public Players(List<Player> players) {
            this.players = players;
        }

        public Player findMaxSalaryPlayer() {
            return players.stream()
                    .max(Player::compareTo)
                    .get();
        }
    }

    static class Player implements Comparable<Player> {
        private final int salary;
        private final String name;

        private Player(int salary, String name) {
            this.salary = salary;
            this.name = name;
        }

        public static Player from(String playerInfo) {
            String[] info = playerInfo.split(" ");
            int salary = Integer.parseInt(info[0]);
            String name = info[1];

            return new Player(salary, name);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Player other) {
            return this.salary - other.salary;
        }
    }
}