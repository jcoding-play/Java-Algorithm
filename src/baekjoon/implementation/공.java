package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(reader.readLine());

        int pos = 1;
        while (M-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int X = Integer.parseInt(tokenizer.nextToken());
            int Y = Integer.parseInt(tokenizer.nextToken());

            if (X == pos || Y == pos) {
                pos = changePos(X, Y, pos);
            }
        }

        System.out.println(pos);
    }

    private static int changePos(int x, int y, int pos) {
        if (x == pos) {
            return y;
        }
        return x;
    }
}
