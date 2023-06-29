package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기 {
    private static final int[] DIRECTION_X = {1, 0, -1, 0};
    private static final int[] DIRECTION_Y = {0, 1, 0, -1};

    private static int N;
    private static int islandName;
    private static int[][] mapName;
    private static boolean[][] isMoved;
    private static List<Edge> edges = new ArrayList<>();
    private static int minBridgeLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = initializeMap(br);
        makeIslandNameAndFindEdges(map);
        findMinBridgeLength(map);

        showMinBridgeLength();
    }

    private static int[][] initializeMap(BufferedReader br) throws IOException {
        int[][] map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }

    private static void makeIslandNameAndFindEdges(int[][] map) {
        mapName = new int[N][N];
        islandName = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                makeIslandName(i, j, map);
                findEdges(i, j, map);
            }
        }
    }

    private static void makeIslandName(int x, int y, int[][] map) {
        if (map[x][y] == 1 && mapName[x][y] == 0) {
            mapName[x][y] = islandName;
            dfs(x, y, map, islandName);
            islandName++;
        }
    }

    private static void findEdges(int x, int y, int[][] map) {
        if (map[x][y] == 0 && isEdge(x, y, map)) {
            edges.add(new Edge(x, y));
        }
    }

    private static boolean isEdge(int x, int y, int[][] map) {
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION_X[i];
            int ny = y + DIRECTION_Y[i];

            if (isOutOfRange(nx, ny)) {
                continue;
            }
            if (map[nx][ny] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOutOfRange(int x, int y) {
        return isOutOfRange(x) || isOutOfRange(y);
    }

    private static boolean isOutOfRange(int value) {
        return value < 0 || value >= N;
    }

    private static void dfs(int x, int y, int[][] map, int name) {
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTION_X[i];
            int ny = y + DIRECTION_Y[i];

            if (isOutOfRange(nx, ny) || isImpossibleToMove(nx, ny, map)) {
                continue;
            }

            mapName[nx][ny] = name;
            dfs(nx, ny, map, name);
        }
    }

    private static boolean isImpossibleToMove(int x, int y, int[][] map) {
        return map[x][y] == 0 || mapName[x][y] != 0;
    }

    private static void findMinBridgeLength(int[][] map) {
        for (Edge edge : edges) {
            isMoved = new boolean[N][N];
            int result = bfs(edge, map);

            minBridgeLength = Math.min(minBridgeLength, result);
        }
    }

    private static int bfs(Edge edge, int[][] map) {
        edge.move();
        int count = 1;
        int nearestIslandName = edge.findNearestIslandName();

        Queue<Edge> queue = new LinkedList<>();
        queue.offer(edge);

        while (!queue.isEmpty()) {
            if (isConnected(map, nearestIslandName, queue)) {
                return count;
            }
            count++;

            if (count >= minBridgeLength) {
                return Integer.MAX_VALUE;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isConnected(int[][] map, int nearestIslandName, Queue<Edge> queue) {
        int size = queue.size();

        while (size-- > 0) {
            Edge currentEdge = queue.poll();
            for (int index = 0; index < 4; index++) {
                Edge nextEdge = currentEdge.findNextPosition(index);
                if (nextEdge == null) {
                    continue;
                }

                if (nextEdge.isConnected(map, nearestIslandName)) {
                    return true;
                }
                if (nextEdge.isIsland(map)) {
                    continue;
                }

                nextEdge.move();
                queue.offer(nextEdge);
            }
        }
        return false;
    }

    private static void showMinBridgeLength() {
        System.out.println(minBridgeLength);
    }

    static class Edge {
        private final int x;
        private final int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            isMoved[x][y] = true;
        }

        public int findNearestIslandName() {
            for (int i = 0; i < 4; i++) {
                int nx = x + DIRECTION_X[i];
                int ny = y + DIRECTION_Y[i];

                if (isOutOfRange(nx, ny)) {
                    continue;
                }

                if (mapName[nx][ny] != 0) {
                    return mapName[nx][ny];
                }
            }
            throw new IllegalArgumentException("섬의 가장자리가 아닙니다.");
        }

        public Edge findNextPosition(int index) {
            int nx = x + DIRECTION_X[index];
            int ny = y + DIRECTION_Y[index];

            if (isOutOfRange(nx, ny)) {
                return null;
            }
            return new Edge(nx, ny);
        }

        public boolean isConnected(int[][] map, int nearestIslandName) {
            return map[x][y] == 1 && mapName[x][y] != nearestIslandName;
        }

        public boolean isIsland(int[][] map) {
            return map[x][y] != 0 || isMoved[x][y];
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
