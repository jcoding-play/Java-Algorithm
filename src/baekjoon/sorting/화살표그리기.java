package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 화살표그리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        Arrays.sort(points);
        int answer = (points[1].pos - points[0].pos) +  (points[n-1].pos - points[n-2].pos);
        for (int i = 1; i < n - 1; i++) {
            int minLength;
            if (points[i - 1].color == points[i].color && points[i].color == points[i + 1].color) {
                int len1 = points[i].pos - points[i - 1].pos;
                int len2 = points[i + 1].pos - points[i].pos;
                minLength = Math.min(len1, len2);
            } else if (points[i - 1].color == points[i].color && points[i].color != points[i + 1].color) {
                minLength = points[i].pos - points[i - 1].pos;
            } else {
                minLength = points[i + 1].pos - points[i].pos;
            }

            answer += minLength;
        }
        System.out.println(answer);
    }

    static class Point implements Comparable<Point> {
        int pos;
        int color;

        public Point(int pos, int color) {
            this.pos = pos;
            this.color = color;
        }

        @Override
        public int compareTo(Point o) {
            if(this.color == o.color) return this.pos - o.pos;
            return this.color - o.color;
        }
    }
}
