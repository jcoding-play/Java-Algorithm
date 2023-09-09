package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 파티가끝나고난뒤 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int numberOfPeople = L * P;

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        IntStream.range(0, 5)
                .map(index -> Integer.parseInt(tokenizer.nextToken()))
                .map(number -> number - numberOfPeople)
                .forEach(result -> System.out.print(result + " "));
    }
}
