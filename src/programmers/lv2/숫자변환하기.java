package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {

    static boolean[] ch = new boolean[1000001];
    static int[] dis = new int[1000001];

    public static int solution(int x, int y, int n) {
        if (x == y) return 0;

        ch[x] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        while (!Q.isEmpty()) {
            int tmp = Q.poll();
            int[] nx = new int[3];
            nx[0] = tmp + n;
            nx[1] = tmp * 2;
            nx[2] = tmp * 3;
            if (isAnswer(nx, y)) {
                return dis[tmp] + 1;
            }
            validateRange(nx, y, tmp, Q);
        }
        return -1;
    }

    private static boolean isAnswer(int[] nx, int y) {
        return nx[0] == y || nx[1] == y || nx[2] == y;
    }

    private static void validateRange(int[] nx, int y, int tmp, Queue<Integer> Q) {
        for (int i = 0; i < 3; i++) {
            if (nx[i] > y) continue;

            if (isPossible(nx[i])) {
                ch[nx[i]] = true;
                dis[nx[i]] = dis[tmp] + 1;
                Q.offer(nx[i]);
            }
        }
    }

    private static boolean isPossible(int n) {
        return n >= 1 && n <= 1000000 && ch[n] == false;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 30;
        System.out.println(solution(x, y, n));
    }
}
