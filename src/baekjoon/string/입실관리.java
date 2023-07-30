package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 입실관리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> names = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names.add(name.toLowerCase());
        }

        names.forEach(System.out::println);
    }
}
