package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
    public static final int DWARFS_NUMBER = 9;
    public static final int SELECTED_DWARFS_NUMBER = 7;
    public static final int TOTAL_HEIGHT = 100;
    public static final String NEWLINE = System.lineSeparator();

    static int[] selected;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[DWARFS_NUMBER];
        for (int i = 0; i < DWARFS_NUMBER; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs);
        selected = new int[SELECTED_DWARFS_NUMBER];
        dfs(dwarfs, 0, 0, 0);
    }

    private static void dfs(int[] dwarfs, int sum, int s, int count) {
        if (sum == TOTAL_HEIGHT && count == SELECTED_DWARFS_NUMBER) {
            System.out.println(getAnswer(dwarfs));
            flag = true;
            return;
        }
        if (sum > TOTAL_HEIGHT || flag || count == SELECTED_DWARFS_NUMBER) {
            return;
        }
        for (int i = s; i < DWARFS_NUMBER; i++) {
            selected[count] = i;
            dfs(dwarfs, sum + dwarfs[i], i + 1, count + 1);
        }
    }

    private static String getAnswer(int[] dwarfs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SELECTED_DWARFS_NUMBER; i++) {
            int selectedIndex = selected[i];
            sb.append(dwarfs[selectedIndex]).append(NEWLINE);
        }
        return sb.toString();
    }
}
