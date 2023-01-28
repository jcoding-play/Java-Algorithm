package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            sb.append(upperBound(x, cards) - lowerBound(x, cards)).append(" ");
        }
        System.out.println(sb);
    }

    private static int upperBound(int x, int[] cards) {
        int lt = 0;
        int rt = cards.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (cards[mid] <= x) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return lt;
    }

    private static int lowerBound(int x, int[] cards) {
        int lt = 0;
        int rt = cards.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (cards[mid] >= x) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}
