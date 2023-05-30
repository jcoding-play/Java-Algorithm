package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행운의바퀴 {

    static boolean[] isUsed = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int currentIndex = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int step = Integer.parseInt(st.nextToken());
            char nextLetter = st.nextToken().charAt(0);

            int nextIndex = ((currentIndex - step) % N + N) % N;
            if(wheel[nextIndex] == '?') wheel[nextIndex] = nextLetter;
            else if (wheel[nextIndex] != nextLetter) {
                System.out.println("!");
                return;
            }
            currentIndex = nextIndex;
        }

        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') {
                continue;
            }
            if (isUsed[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            isUsed[wheel[i] - 'A'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(wheel[(currentIndex + i) % N]);
        }
        System.out.println(sb);
    }
}
