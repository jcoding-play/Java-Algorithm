package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            String person = br.readLine();
            if (set.contains(person)) {
                count++;
                list.add(person);
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
