package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {
    public static int solution(String dirs) {
        int answer = 0;

        Set<String> set = new HashSet<>();
        Point nowPos = new Point(0, 0);
        for (char move : dirs.toCharArray()) {
            Point nextPos = getNextPos(nowPos, move);
            if (outOfBoundary(nextPos)) continue;

            String path = getPath(nowPos, nextPos);
            if (!set.contains(path)) {
                answer++;
            }
            String reversePath = getPath(nextPos, nowPos);
            //System.out.println("path = " + path + " ****** reversePath = " + reversePath);
            set.add(path);
            set.add(reversePath);
            nowPos = nextPos;
        }
        return answer;
    }

    private static Point getNextPos(Point nowPos, char move) {
        Point nextPos;
        if (move == 'U') {
            nextPos = new Point(nowPos.x, nowPos.y + 1);
        } else if (move == 'D') {
            nextPos = new Point(nowPos.x, nowPos.y - 1);
        } else if (move == 'R') {
            nextPos = new Point(nowPos.x + 1, nowPos.y);
        } else {
            nextPos = new Point(nowPos.x - 1, nowPos.y);
        }
        return nextPos;
    }

    private static boolean outOfBoundary(Point pos) {
        return pos.x > 5 || pos.y > 5 || pos.x < -5 || pos.y < -5;
    }

    private static String getPath(Point pos1, Point pos2) {
        return pointToString(pos1) + " -> " + pointToString(pos2);
    }

    private static String pointToString(Point pos) {
        return "(" + pos.x + ", " + pos.y + ")";
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }
}
