package programmers.lv2;

public class 예상대진표 {
    public static int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            if (a % 2 != 0) {
                a = a / 2 + 1;
            } else {
                a = a / 2;
            }

            if (b % 2 != 0) {
                b = b / 2 + 1;
            } else {
                b = b / 2;
            }

            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 1;
        int b = 2;
        System.out.println(solution(n, a, b));
    }
}
