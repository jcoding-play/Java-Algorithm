package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_dfs {

    static int[] parentNode;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        ch = new boolean[n + 1];
        parentNode = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        ch[1] = true;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parentNode[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int node) {
        for (int nextNode : tree.get(node)) {
            if (ch[nextNode] == false) {
                ch[nextNode] = true;
                parentNode[nextNode] = node;
                dfs(nextNode);
            }
        }
    }
}
