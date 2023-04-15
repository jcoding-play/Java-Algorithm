package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int L = 1;

        maps[0][0] = 0;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        while (!Q.isEmpty()) {
            int len = Q.size();

            while (len-- > 0) {
                int[] tmp = Q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx == n-1 && ny == m-1) return L + 1;

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                        maps[nx][ny] = 0;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
}
