package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] treeParent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        treeParent = new int[n + 1];
        treeParent[1] = 1;
        DFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(treeParent[i]);
        }
    }

    private static void DFS(int L) {
        for (int x : list.get(L)) {
            if (treeParent[x] == 0) {
                treeParent[x] = L;
                DFS(x);
            }
        }
    }
}
