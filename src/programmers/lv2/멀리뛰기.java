package programmers.lv2;

public class 멀리뛰기 {

    public static long solution(int n) {
        long answer = 0;
        if (n == 1) return 1;

        long[] dy = new long[n + 1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i-2] + dy[i-1]) % 1234567;
        }
        answer = dy[n];
        return answer;
    }

    public static void main(String[] args) {
        int n = 2000;
        System.out.println(solution(n));
    }
}
