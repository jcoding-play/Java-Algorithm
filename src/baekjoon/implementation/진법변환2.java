package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 진법변환2 {

    static Map<Integer, Character> store = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static {
        int initNumber = 10;
        char initCharacter = 'A';
        for (int i = 0; i < 26; i++) {
            store.put(initNumber++, initCharacter++);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dfs(N, B);
        System.out.println(sb);
    }

    private static void dfs(int N, int B) {
        if (N == 0) {
            return;
        }
        dfs(N / B, B);
        generateNumber(N % B);
    }

    private static void generateNumber(int n) {
        if (store.containsKey(n)) {
            sb.append(store.get(n));
            return;
        }
        sb.append(n);
    }
}
