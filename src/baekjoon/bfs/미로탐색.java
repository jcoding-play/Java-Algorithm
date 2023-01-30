package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = br.read() - '0';
            }
            br.read();
        }
        System.out.println(BFS(1, 1));
    }

    private static int BFS(int s, int e) {
        map[s][e] = 0;
        int answer = 1;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s, e});
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = Q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx==N && ny==M) return answer + 1;
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
