package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()), null, null);
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) break;

            insert(root, Integer.parseInt(str));
        }

        postOrder(root);
        System.out.print(sb);
    }

    private static void insert(Node head, int n) {
        if (head.node > n) {
            if (head.lt == null) head.lt = new Node(n, null, null);
            else insert(head.lt, n);
        } else {
            if (head.rt == null) head.rt = new Node(n, null, null);
            else insert(head.rt, n);
        }
    }

    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.lt);
        postOrder(node.rt);
        sb.append(node.node).append('\n');
    }

    static class Node {
        int node;
        Node lt;
        Node rt;

        public Node(int node, Node lt, Node rt) {
            this.node = node;
            this.lt = lt;
            this.rt = rt;
        }
    }
}
