package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리 {

    static int n, m, rootNode;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ch = new boolean[n];
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                rootNode = i;
            } else {
                list.get(i).add(parent);
                list.get(parent).add(i);
            }
        }
        m = Integer.parseInt(br.readLine());

        if (rootNode == m) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    private static void bfs() {
        int answer = 0;

        ch[rootNode] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(rootNode);
        while (!Q.isEmpty()) {
            int tmp = Q.poll();

            int count = 0;
            for (int childNode : list.get(tmp)) {
                if (childNode == m) continue;

                if (ch[childNode] == false) {
                    ch[childNode] = true;
                    count++;
                    Q.offer(childNode);
                }
            }
            if (count == 0) answer++;
        }
        System.out.println(answer);
    }
}
