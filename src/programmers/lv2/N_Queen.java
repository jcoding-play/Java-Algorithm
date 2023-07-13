package programmers.lv2;

public class N_Queen {
    private static int[][] queen_pos;
    private static int answer = 0;

    public static int solution(int n) {
        queen_pos = new int[n][n];
        deployQueen(0, n);

        return answer;
    }

    private static void deployQueen(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isImpossibleToDeploy(row, col, n)) {
                continue;
            }

            queen_pos[row][col] = 1;
            deployQueen(row + 1, n);
            queen_pos[row][col] = 0;
        }
    }

    private static boolean isImpossibleToDeploy(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (checkPosition(row, col, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean checkPosition(int row, int col, int i, int j) {
        if (queen_pos[i][j] == 1) {
            if (i == row || j == col) {
                return true;
            }
            if (i + j == row + col || i - j == row - col) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int result = solution(4);
        System.out.println(result);
    }
}
