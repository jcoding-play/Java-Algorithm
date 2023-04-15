package programmers.lv2;

public class _2xN타일링 {

    static int[] dy;

    public static int solution(int n) {

        dy = new int[n + 1];

        int answer = getAnswer(n);
        return answer;
    }

    private static int getAnswer(int n) {
        dy[1] = 1;
        if (n >= 2) dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % 1000000007;
        }

        return dy[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
