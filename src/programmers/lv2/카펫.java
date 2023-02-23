package programmers.lv2;

public class 카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int count = brown + yellow;
        int width;
        int length = 2;
        while (true) {
            length++;
            if (length >= count) break;
            if (count % length != 0) continue;

            width = count / length;

            if ((width - 2) * (length - 2) == yellow) {
                answer[0] = width;
                answer[1] = length;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int brown = 5000;
        int yellow = 2000000;

        for (int x : solution(brown, yellow)) {
            System.out.print(x + " ");
        }
    }
}
