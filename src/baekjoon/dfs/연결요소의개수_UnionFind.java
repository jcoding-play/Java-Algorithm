package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 DFS 알고리즘 분류로 나타나있지만, Union&Find 알고리즘을 이용한 문제 풀이
 */
public class 연결요소의개수_UnionFind {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Union(a, b);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(Find(i));
        }
        System.out.println(set.size());
    }

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    private static int Find(int n) {
        if(unf[n]==n) return n;
        else return unf[n] = Find(unf[n]);
    }
}
