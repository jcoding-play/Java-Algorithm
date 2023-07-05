package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 전화번호목록 {
    private static final String NEWLINE = System.lineSeparator();
    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            recordResult(br, n);
            resultBuilder.append(NEWLINE);
        }

        System.out.print(resultBuilder);
    }

    private static void recordResult(BufferedReader br, int n) throws IOException {
        if (checkPhoneNumbers(initializePhoneNumbers(br, n))) {
            resultBuilder.append("YES");
            return;
        }
        resultBuilder.append("NO");
    }

    private static List<String> initializePhoneNumbers(BufferedReader br, int n) throws IOException {
        List<String> phoneNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            phoneNumbers.add(br.readLine());
        }
        Collections.sort(phoneNumbers);

        return phoneNumbers;
    }

    private static boolean checkPhoneNumbers(List<String> phoneNumbers) {
        for (int i = 0; i < phoneNumbers.size() - 1; i++) {
            String phoneNumber = phoneNumbers.get(i);

            if (phoneNumbers.get(i + 1).startsWith(phoneNumber)) {
                return false;
            }
        }
        return true;
    }
}
