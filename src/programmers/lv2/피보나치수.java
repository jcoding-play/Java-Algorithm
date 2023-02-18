package programmers.lv2;

public class 피보나치수 {

    static int[] arr;

    public static int solution(int n) {
        int answer = 0;
        arr = new int[n+1];
        answer = fibo(n);

        return answer;
    }

    private static int fibo(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 100000;
        System.out.println(solution(n));
    }
}
