package baekjoon.implementation;

import java.util.*;
import java.util.stream.Collectors;

public class 주사위게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        List<Player> players = initPlayers(scanner, N);

        DiceGame diceGame = new DiceGame(players);
        System.out.println(diceGame.findMaxPrizeMoney());
    }

    private static List<Player> initPlayers(Scanner scanner, int N) {
        List<Player> players = new ArrayList<>();

        while (N-- > 0) {
            String source = scanner.nextLine();
            players.add(new Player(source));
        }

        return players;
    }
}

class DiceGame {
    private final List<Player> players;

    public DiceGame(List<Player> players) {
        this.players = players;
    }

    public int findMaxPrizeMoney() {
        return players.stream()
                .map(Player::calculatePrize)
                .max(Comparator.naturalOrder())
                .get();
    }
}

class Player {
    private static final String SCORE_DELIMITER = " ";

    private final Map<Integer, Integer> scoreMap = new HashMap<>();

    public Player(String source) {
        for (int score : initScores(source)) {
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        }
    }

    private List<Integer> initScores(String source) {
        return Arrays.stream(source.split(SCORE_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculatePrize() {
        int score = findScore();
        int count = scoreMap.get(score);

        return calculatePrize(score, count);
    }

    private int calculatePrize(int score, int count) {
        if (count == 3) {
            return 10000 + score * 1000;
        }
        if (count == 2) {
            return 1000 + score * 100;
        }
        return score * 100;
    }

    protected int findScore() {
        return scoreMap.keySet()
                .stream()
                .max(getIntegerComparator())
                .get();
    }

    private Comparator<Integer> getIntegerComparator() {
        return (o1, o2) -> {
            if (scoreMap.get(o1) == scoreMap.get(o2)) {
                return o1 - o2;
            }
            return scoreMap.get(o1) - scoreMap.get(o2);
        };
    }
}