package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타줄 {

    static int[] bundle;
    static int[] piece;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bundle = new int[m];
        piece = new int[m];
        dataInit(br, m);

        System.out.println(min(getBuyBundle(n), getBuyPiece(n), getBuyBundleAndPiece(n)));
    }

    private static void dataInit(BufferedReader br, int m) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            bundle[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bundle);
        Arrays.sort(piece);
    }

    private static int getBuyBundle(int n) {
        int bundleCount = n / 6;
        if (n % 6 != 0) {
            bundleCount++;
        }
        return bundleCount * bundle[0];
    }

    private static int getBuyPiece(int n) {
        return n * piece[0];
    }

    private static int getBuyBundleAndPiece(int n) {
        int bundleCount = n / 6;
        int pieceCount = n % 6;
        return bundleCount * bundle[0] + pieceCount * piece[0];
    }

    private static int min(int buyBundle, int buyPiece, int buyBundleAndPiece) {
        return Math.min(buyBundle, Math.min(buyPiece, buyBundleAndPiece));
    }
}
