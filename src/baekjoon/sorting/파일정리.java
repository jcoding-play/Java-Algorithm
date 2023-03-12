package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            int index = str[i].lastIndexOf(".");

            str[i] = str[i].substring(index + 1);
        }

        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        String last = str[0];
        for (int i = 1; i < n; i++) {
            if (str[i].equals(last)) {
                count++;
            } else {
                sb.append(last).append(' ').append(count).append('\n');
                count = 1;
                last = str[i];
            }
        }
        sb.append(last).append(' ').append(count).append('\n');
        System.out.print(sb);
    }
}
