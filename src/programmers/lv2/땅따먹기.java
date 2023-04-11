package programmers.lv2;

import java.util.Arrays;

public class 땅따먹기 {

    static int[][] dy;

    public static int solution(int[][] land) {
        int answer;
        int len = land.length;

        dy = new int[len + 1][5];
        dy[1][1] = land[0][0];
        dy[1][2] = land[0][1];
        dy[1][3] = land[0][2];
        dy[1][4] = land[0][3];
        for (int i = 2; i <= len; i++) {
            dy[i][1] = Math.max(Math.max(dy[i-1][2], dy[i-1][3]), dy[i-1][4]) + land[i-1][0];
            dy[i][2] = Math.max(Math.max(dy[i-1][1], dy[i-1][3]), dy[i-1][4]) + land[i-1][1];
            dy[i][3] = Math.max(Math.max(dy[i-1][1], dy[i-1][2]), dy[i-1][4]) + land[i-1][2];
            dy[i][4] = Math.max(Math.max(dy[i-1][1], dy[i-1][2]), dy[i-1][3]) + land[i-1][3];
        }
        answer = Arrays.stream(dy[len]).max().getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(land));
    }
}
