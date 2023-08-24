package baekjoon.implementation.b14503.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputView {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String inputRoomSize() throws IOException {
        return reader.readLine();
    }

    public String inputPointAndDirection() throws IOException {
        return reader.readLine();
    }

    public int[][] inputRoomInfo(int N, int M) throws IOException {
        int[][] roomInfo = new int[N][M];

        StringTokenizer stringTokenizer;
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < M; j++) {
                roomInfo[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        return roomInfo;
    }
}
