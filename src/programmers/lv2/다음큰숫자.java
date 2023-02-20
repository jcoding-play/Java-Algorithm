package programmers.lv2;

public class 다음큰숫자 {
    public static int solution(int n) {
        int answer = 0;
        int nowCount = Integer.bitCount(n);
        while (true) {
            n++;
            int nextCount = Integer.bitCount(n);
            if (nowCount == nextCount) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
