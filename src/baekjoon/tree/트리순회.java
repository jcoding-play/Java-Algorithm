package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리순회 {

    static ArrayList<Tree> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            list.add(new Tree(a, b, c));
        }

        ArrayList<Tree> tmp = (ArrayList<Tree>) list.clone();
        pre_dfs('A', tmp);
        sb.append('\n');
        tmp = (ArrayList<Tree>) list.clone();
        in_dfs('A', tmp);
        sb.append('\n');
        tmp = (ArrayList<Tree>) list.clone();
        post_dfs('A', tmp);
        System.out.println(sb);
    }

    private static void pre_dfs(char node, ArrayList<Tree> tmp) {
        if (node == '.') return;

        for (Tree tree : tmp) {
            if (tree.node == node) {
                sb.append(node);
                pre_dfs(tree.lt, tmp);
                pre_dfs(tree.rt, tmp);
                tmp.remove(tree);
                break;
            }
        }
    }

    private static void in_dfs(char node, ArrayList<Tree> tmp) {
        if (node == '.') return;

        for (Tree tree : tmp) {
            if (tree.node == node) {
                in_dfs(tree.lt, tmp);
                sb.append(node);
                in_dfs(tree.rt, tmp);
                tmp.remove(tree);
                break;
            }
        }
    }

    private static void post_dfs(char node, ArrayList<Tree> tmp) {
        if (node == '.') return;

        for (Tree tree : tmp) {
            if (tree.node == node) {
                post_dfs(tree.lt, tmp);
                post_dfs(tree.rt, tmp);
                sb.append(node);
                tmp.remove(tree);
                break;
            }
        }
    }

    static class Tree {
        char node;
        char lt;
        char rt;

        public Tree(char node, char lt, char rt) {
            this.node = node;
            this.lt = lt;
            this.rt = rt;
        }
    }
}
