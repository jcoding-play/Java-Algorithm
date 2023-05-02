package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (endCondition(L, P, V)) {
                break;
            }

            sb.append("Case " + count + ": " + getCampingDate(L, P, V) + "\n");
            count++;
        }
        System.out.print(sb);
    }

    private static boolean endCondition(int L, int P, int V) {
        return L == 0 && P == 0 && V == 0;
    }

    private static int getCampingDate(int L, int P, int V) {
        int campingDate = (V / P) * L;
        if (V % P > L) {
            return campingDate + L;
        }
        return campingDate + V % P;
    }
}
