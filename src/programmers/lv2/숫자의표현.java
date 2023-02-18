package programmers.lv2;

public class 숫자의표현 {
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            } else if (sum > n) {
                while (sum > n) {
                    sum -= lt;
                    if (sum == n) {
                        answer++;
                    }
                    lt++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}
