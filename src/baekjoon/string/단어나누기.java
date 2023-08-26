package baekjoon.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단어나누기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> result = new ArrayList<>();

        int length = input.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    String firstWord = input.substring(0, j);
                    String secondWord = input.substring(j, k);
                    String thirdWord = input.substring(k, length);

                    firstWord = new StringBuilder(firstWord).reverse().toString();
                    secondWord = new StringBuilder(secondWord).reverse().toString();
                    thirdWord = new StringBuilder(thirdWord).reverse().toString();

                    result.add(firstWord + secondWord + thirdWord);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.get(0));
    }
}
