package baekjoon.implementation.b16236.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    @DisplayName("x, y 좌표 값을 가진다.")
    void create() {
        Point point = new Point(1, 1);
        assertEquals(new Point(1, 1), point);
    }

    @Test
    @DisplayName("좌표를 x 좌표에 오름차순으로 정렬하고 x 좌표가 같다면 y 좌표를 기준으로 오름차순으로 정렬한다.")
    void compareTo() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 1));
        points.add(new Point(1, 1));
        points.add(new Point(1, 0));
        Collections.sort(points);

        assertEquals(new Point(1, 0), points.get(0));
        assertEquals(new Point(1, 1), points.get(1));
        assertEquals(new Point(2, 1), points.get(2));
    }
}