package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {

    static int[][] map;
    static int m, n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            makeSquare(st);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    int count = BFS(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int x : list) {
            System.out.print(x + " ");
        }
    }

    private static void makeSquare(StringTokenizer st) {
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[j][i] = 1;
            }
        }
    }

    private static int BFS(int x, int y) {
        map[x][y] = 1;
        int count = 1;

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<m && ny<n && map[nx][ny]==0) {
                    map[nx][ny] = 1;
                    count++;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}
