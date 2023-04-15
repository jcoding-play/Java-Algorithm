package programmers.lv2;

public class 프렌즈4블록 {

    static char[][] map;
    static boolean[][] ch;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];
        createMap(m, n, board);

        while (true) {
            ch = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    validationSquare(i, j);
                }
            }
            int result = countBlocks(m, n);
            if (result == 0) break;

            answer += result;
            createNewMap(m, n, map);
        }
        return answer;
    }

    private static void createMap(int m, int n, String[] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
    }

    private static void validationSquare(int x, int y) {
        char tmp = map[x][y];
        if (tmp == 'X') return;

        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[nx][ny] != tmp) {
                flag = false;
                break;
            }
        }

        if (flag) {
            ch[x][y] = true;
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                ch[nx][ny] = true;
            }
        }
    }

    private static int countBlocks(int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j]) {
                    count++;
                    map[i][j] = 'X';
                }
            }
        }
        return count;
    }

    private static void createNewMap(int m, int n, char[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                if (map[j][i] != 'X' && map[j + 1][i] == 'X') {
                    pushDown(i, j, m, map);
                }
            }
        }
    }

    private static void pushDown(int i, int j, int m, char[][] map) {
        int count = 0;
        int nj = j + 1;

        while (nj < m && map[nj][i] == 'X') {
            count++;
            nj++;
        }

        char tmp = map[j][i];
        map[j][i] = map[j + count][i];
        map[j + count][i] = tmp;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m, n, board));
    }
}
