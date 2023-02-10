package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {

    static int[][] relation;
    static int[] ch;
    static int n;
    static int answer = -1;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        relation = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relation[x][y] = 1;
            relation[y][x] = 1;
        }

        DFS(a, b, 0);
        System.out.println(answer);
    }

    private static void DFS(int a, int b, int count) {
        if(flag) return;

        if (a == b) {
            flag = true;
            answer = count;
        } else {
            for (int i = 1; i <= n; i++) {
                if (relation[a][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i, b, count + 1);
                }
            }
        }
    }
}
