package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static ArrayList<Virus> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    list.add(new Virus(i, j));
                }
            }
        }

        makeWall(0);
        System.out.println(answer);
    }

    private static void makeWall(int L) {
        if(L==3){
            int count = BFS();
            answer = Math.max(answer, count);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        makeWall(L+1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int BFS() {
        boolean[][] ch = new boolean[n][m];

        Queue<Virus> Q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Virus virus = list.get(i);
            Q.offer(new Virus(virus.x, virus.y));
        }
        while (!Q.isEmpty()) {
            Virus v = Q.poll();
            int x = v.x;
            int y = v.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==0 && ch[nx][ny]==false){
                    ch[nx][ny] = true;
                    Q.offer(new Virus(nx, ny));
                }
            }
        }

        int count = 0; //안전 영역 개수 구하는 변수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && ch[i][j] == false) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Virus {
    int x;
    int y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}