package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소금폭탄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] currentTimeString = br.readLine().split(":");
        String[] putSortTimeString = br.readLine().split(":");

        int currentSecondFormat = stringTimeToSecondFormat(currentTimeString);
        int putSortSecondFormat = stringTimeToSecondFormat(putSortTimeString);
        int answerSecondFormat = validateSecondFormat(putSortSecondFormat - currentSecondFormat);

        System.out.println(secondFormatToStringTimeFormat(answerSecondFormat));
    }

    private static int stringTimeToSecondFormat(String[] timeString) {
        return Integer.parseInt(timeString[0]) * 3600
                + Integer.parseInt(timeString[1]) * 60
                + Integer.parseInt(timeString[2]);
    }

    private static int validateSecondFormat(int answerTimeSecond) {
        if (answerTimeSecond <= 0) {
            answerTimeSecond += 24 * 3600;
        }
        return answerTimeSecond;
    }

    private static String secondFormatToStringTimeFormat(int answerTimeSecond) {
        String hour = integerToString(answerTimeSecond / 3600);
        answerTimeSecond = answerTimeSecond % 3600;

        String minute = integerToString(answerTimeSecond / 60);
        answerTimeSecond = answerTimeSecond % 60;

        String second = integerToString(answerTimeSecond);
        return hour + ":" + minute + ":" + second;
    }

    private static String integerToString(int time) {
        String timeString = String.valueOf(time);
        if (timeString.length() == 1) {
            timeString = "0" + timeString;
        }
        return timeString;
    }
}
