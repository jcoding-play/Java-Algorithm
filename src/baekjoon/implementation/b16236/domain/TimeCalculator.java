package baekjoon.implementation.b16236.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TimeCalculator {
    private final Board board;
    private final Shark shark;
    private int totalTime = 0;

    public TimeCalculator(Board board, Shark shark) {
        this.board = board;
        this.shark = shark;
    }

    public Point findMinDistancePoint() {
        List<Point> edibleFishPoints = board.findEdibleFishPoints(shark.getSize());
        validateEdibleFishPoints(edibleFishPoints);

        List<Point> points = findMinDistancePoints(edibleFishPoints);
        Collections.sort(points);
        return points.get(0);
    }

    private void validateEdibleFishPoints(List<Point> edibleFishPoints) {
        if (edibleFishPoints.size() == 0) {
            throw new IllegalArgumentException("먹을 수 있는 물고기가 없습니다.");
        }
    }

    private List<Point> findMinDistancePoints(List<Point> edibleFishPoints) {
        int[][] distanceInfo = board.bfs(shark);
        int minDistance = calculateMinDistance(distanceInfo, edibleFishPoints);
        totalTime += minDistance;

        return findMinDistancePoints(edibleFishPoints, distanceInfo, minDistance);
    }

    private int calculateMinDistance(int[][] distanceInfo, List<Point> edibleFishPoints) {
        return edibleFishPoints.stream()
                .map(point -> point.calculateDistance(distanceInfo))
                .filter(distance -> distance != 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("먹을 수 있는 물고기가 없습니다."));
    }

    private List<Point> findMinDistancePoints(List<Point> edibleFishPoints, int[][] distanceInfo, int distance) {
        return edibleFishPoints.stream()
                .filter(point -> point.isMinDistancePoint(distanceInfo, distance))
                .collect(Collectors.toList());
    }

    public int calculateTotalTime() {
        while (true) {
            try {
                Point point = findMinDistancePoint();
                shark.eatFish(board, point.getX(), point.getY());
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return totalTime;
    }
}
