package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 성택이의은밀한비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            passwords.add(br.readLine());
        }

        showResult(passwords);
    }

    private static void showResult(List<String> passwords) {
        StringBuilder resultBuilder = new StringBuilder();

        for (String password : passwords) {
            int length = password.length();

            if (length >= 6 && length <= 9) {
                resultBuilder.append("yes").append('\n');
                continue;
            }
            resultBuilder.append("no").append('\n');
        }

        System.out.println(resultBuilder);
    }
}
