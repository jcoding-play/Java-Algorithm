package programmers.lv2;

import java.util.Arrays;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strings = integerToString(numbers);

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (strings[0].startsWith("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        answer = sb.toString();
        return answer;
    }

    private static String[] integerToString(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        return str;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2, 12, 31, 21, 221, 223, 225};
        System.out.println(solution(numbers));
    }
}
