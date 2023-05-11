package programmers.lv2;

import java.util.Arrays;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"12", "123", "1235"};
        System.out.println(solution(phone_book));
    }
}
