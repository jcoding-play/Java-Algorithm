package programmers.lv2;

public class n2배열자르기 {
    public static int[] solution(int n, long left, long right) {
        long len = right - left + 1;
        int[] answer = new int[(int) len];

        for (int i = 0; i < len; i++) {
            long x = left / n;
            long y = left % n;
            if (y == 0) {
                answer[i] = (int) x + 1;
            } else if (y == n - 1) {
                answer[i] = n;
            } else {
                if (x > y) {
                    answer[i] = (int) x + 1;
                } else {
                    answer[i] = (int) y + 1;
                }
            }
            left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        for (int x : solution(n, left, right)) {
            System.out.print(x + " ");
        }
    }
}
