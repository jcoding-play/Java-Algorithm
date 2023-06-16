package baekjoon.bfs;

import java.util.*;
import java.util.function.Function;

public class 숨바꼭질3 {
    private static final Map<Integer, Function<Integer, Integer>> POSITION_CALCULATOR = new HashMap<>();
    private static final Map<Integer, Function<Integer, Integer>> TIME_MEASURING = new HashMap<>();

    static {
        POSITION_CALCULATOR.put(1, position -> position * 2);
        POSITION_CALCULATOR.put(2, position -> position - 1);
        POSITION_CALCULATOR.put(3, position -> position + 1);

        TIME_MEASURING.put(1, time -> time);
        TIME_MEASURING.put(2, time -> time + 1);
        TIME_MEASURING.put(3, time -> time + 1);
    }

    private static boolean[] isMoved = new boolean[100001];

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.println(result);
    }

    private static int bfs(int subinPosition, int brotherPosition) {
        isMoved[subinPosition] = true;
        Queue<Subin> queue = new LinkedList<>();
        queue.add(new Subin(subinPosition, 0));

        while (!queue.isEmpty()) {
            Subin subin = queue.poll();
            int time = subin.getTime();
            if (subin.isSamePosition(brotherPosition)) {
                return time;
            }

            int position = subin.getPosition();
            for (int i = 1; i <= 3; i++) {
                int nextPosition = POSITION_CALCULATOR.get(i).apply(position);
                if (isImpossibleToMove(nextPosition)) {
                    continue;
                }

                isMoved[nextPosition] = true;
                int nextTime = TIME_MEASURING.get(i).apply(time);
                queue.add(new Subin(nextPosition, nextTime));
            }
        }
        throw new IllegalArgumentException("잘못된 위치값입니다.");
    }

    private static boolean isImpossibleToMove(int nextPosition) {
        return isOutOfRange(nextPosition) || isMoved[nextPosition];
    }

    private static boolean isOutOfRange(int position) {
        return position < 0 || position > 100000;
    }
}

class Subin {
    private final int position;
    private final int time;

    public Subin(int position, int time) {
        this.position = position;
        this.time = time;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public int getTime() {
        return time;
    }
}