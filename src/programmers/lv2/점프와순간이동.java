package programmers.lv2;

public class 점프와순간이동 {

    public static int solution(int n) {
        int answer = 1;
        while (n > 1) {
            if (n % 2 != 0) {
                n = n - 1;
                answer++;
            }
            n = n / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 1000000000;
        System.out.println(solution(n));
    }
}
