package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meeting = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            meeting.add(new Meeting(x, y));
        }

        Collections.sort(meeting);
        int answer = 0;
        int end = 0; //회의실을 사용하고 있는 회의 끝나는 시간을 저장
        for (Meeting m : meeting) {
            if (m.s >= end) {
                answer++;
                end = m.e;
            }
        }
        System.out.println(answer);
    }
}

class Meeting implements Comparable<Meeting> {
    int s;
    int e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}