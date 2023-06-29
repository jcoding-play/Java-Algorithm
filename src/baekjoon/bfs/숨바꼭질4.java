package baekjoon.bfs;

import java.util.*;
import java.util.function.Function;

public class 숨바꼭질4 {
    private static final Map<Integer, Function<Integer, Integer>> DIRECTION_OF_POSITION = new HashMap<>();

    static {
        DIRECTION_OF_POSITION.put(1, position -> position - 1);
        DIRECTION_OF_POSITION.put(2, position -> position + 1);
        DIRECTION_OF_POSITION.put(3, position -> position * 2);
    }

    private static int[] time = new int[100001];
    private static int[] parent = new int[100001];
    private static boolean[] isMoved = new boolean[100001];

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.printf("%d\n%d", 0, N);
            return;
        }

        System.out.println(bfs(N, K));
        showRoutes(N, K);
    }

    private static int bfs(int n, int k) {
        isMoved[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int position = queue.poll();
            if (position == k) {
                return time[position];
            }

            for (int i = 1; i <= 3; i++) {
                int nextPosition = DIRECTION_OF_POSITION.get(i).apply(position);
                if (isImpossibleToMove(nextPosition)) {
                    continue;
                }

                isMoved[nextPosition] = true;
                time[nextPosition] = time[position] + 1;
                parent[nextPosition] = position;
                queue.offer(nextPosition);
            }
        }
        return -1;
    }

    private static boolean isImpossibleToMove(int position) {
        return position < 0 || position > 100000 || isMoved[position];
    }

    private static void showRoutes(int N, int K) {
        List<Integer> routes = new ArrayList<>();
        int index = K;
        while (index != N) {
            routes.add(index);
            index = parent[index];
        }
        routes.add(N);

        Collections.reverse(routes);
        routes.forEach(route -> System.out.print(route + " "));
    }
}
