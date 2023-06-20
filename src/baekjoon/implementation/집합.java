package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합 {
    private static Set<Integer> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String command;
        int x;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
                run(command, x);
                continue;
            }
            run(command);
        }

        System.out.print(sb);
    }

    private static void run(String command, int x) {
        if (command.equals("add")) {
            set.add(x);
            return;
        }
        if (command.equals("remove")) {
            set.remove(x);
            return;
        }
        if (command.equals("check")) {
            if (set.contains(x)) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
            return;
        }
        if (command.equals("toggle")) {
            if (set.contains(x)) {
                set.remove(x);
                return;
            }
            set.add(x);
        }
    }

    private static void run(String command) {
        if (command.equals("all")) {
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
            return;
        }
        if (command.equals("empty")) {
            set = new HashSet<>();
        }
    }
}
