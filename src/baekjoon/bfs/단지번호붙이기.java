package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기 {

    static int[][] house;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /**
         * 배열의 범위를 [N+2][N+2]로 한 이유는,
         * 밑에서 배열의 인덱스 범위가 벗어났는지 확인하기 위해 nx>=0 && nx<N 과 같이 조건문을 이용해야 한다.
         * 하지만 배열의 범위를 다음과 같이 지정하면 위와 같은 조건문은 생략할 수 있다. (미리 경계값을 추가했다고 생각하면 된다.)
         */
        house = new int[N+2][N+2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                house[i][j] = br.read() - '0';
            }
            br.read(); // '\n' 값 입력
        }

        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (house[i][j] == 1) {
                    house[i][j] = 0;
                    count = 1;
                    answer++;
                    BFS(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for (int x : list) {
            System.out.println(x);
        }
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    /**
                     * 여기서 만약 배열의 범위가 [N+2][N+2]가 아니고 [N][N] 이라면,
                     * if(nx>=0 && nx<N && ny>=0 && ny<N && house[nx][ny]==1) 과 같이 작성해야한다.
                     */
                    if (house[nx][ny] == 1) {
                        house[nx][ny] = 0;
                        count++;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}