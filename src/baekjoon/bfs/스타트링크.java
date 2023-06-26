package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 스타트링크 {
    private static int F;
    private static int S;
    private static int G;
    private static int U;
    private static int D;
    private static int[] count;
    private static boolean[] isMoved;

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        count = new int[F + 1];
        isMoved = new boolean[F + 1];

        printResult();
    }

    private static void printResult() {
        if (S == G) {
            System.out.println(0);
            return;
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(result);
    }

    private static int bfs() {
        isMoved[S] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int currentFloor = queue.poll();
            int nextUpFloor = currentFloor + U;
            int nextDownFloor = currentFloor - D;

            if (nextUpFloor == G || nextDownFloor == G) {
                return count[currentFloor] + 1;
            }

            move(queue, currentFloor, nextUpFloor);
            move(queue, currentFloor, nextDownFloor);
        }

        return -1;
    }

    private static void move(Queue<Integer> queue, int currentFloor, int nextFloor) {
        if (isImpossibleToMove(nextFloor)) {
            return;
        }

        isMoved[nextFloor] = true;
        count[nextFloor] = count[currentFloor] + 1;
        queue.add(nextFloor);
    }

    private static boolean isImpossibleToMove(int floor) {
        return floor <= 0 || floor > F || isMoved[floor];
    }
}
