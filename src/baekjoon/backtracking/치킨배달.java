package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    static int n, m;
    static int[][] map;
    static List<Point> houses = new ArrayList<>(); //집에 해당하는 좌표를 보관
    static List<Point> chicken = new ArrayList<>(); //치킨집에 해당하는 좌표를 보관
    static int[] selectedChicken; //선택된 치킨집의 인덱스를 저장
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        selectedChicken = new int[m];
        selectChicken(0, 0);
        System.out.println(answer);
    }

    private static void selectChicken(int L, int s) {
        if (L == m) {
            answer = Math.min(answer, checkLength());
        } else {
            for (int i = s; i < chicken.size(); i++) {
                selectedChicken[L] = i;
                selectChicken(L + 1, i + 1);
            }
        }
    }

    /**
     * 각각의 집 좌표에서 가장 가까운 치킨집과의 거리를 모두 더한 후 리턴해준다.
     */
    private static int checkLength() {
        int sum = 0;
        for (Point house : houses) {
            int minLength = Integer.MAX_VALUE;
            for (int i : selectedChicken) {
                Point ck = chicken.get(i);

                int length = Math.abs(house.r - ck.r) + Math.abs(house.c - ck.c);
                minLength = Math.min(minLength, length);
            }
            sum += minLength;
        }
        return sum;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
