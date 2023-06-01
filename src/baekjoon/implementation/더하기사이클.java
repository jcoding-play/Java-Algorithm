package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int currentNumber = N;
        int answer = 0;
        while (true) {
            currentNumber = getNewNumber(currentNumber);
            answer++;

            if (currentNumber == N) {
                System.out.println(answer);
                return;
            }
        }
    }

    private static int getNewNumber(int currentNumber) {
        int firstDigit = currentNumber / 10;
        int secondDigit = currentNumber % 10;
        int number = firstDigit + secondDigit;

        return (secondDigit * 10) + (number % 10);
    }
}
