package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 영역구하기 {

    static int[][] graph;
    static int area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            makeSquare(st);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    area = 1;
                    DFS(i, j);
                    list.add(area);
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
                graph[j][i] = 1;
            }
        }
    }

    private static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n && graph[nx][ny]==0) {
                graph[nx][ny] = 1;
                area++;
                DFS(nx, ny);
            }
        }
    }
}
