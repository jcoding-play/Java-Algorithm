package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Study> pQ = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pQ.offer(new Study(a, 's'));
            pQ.offer(new Study(b, 'e'));
        }

        int answer = 0;
        int count = 0;
        while (!pQ.isEmpty()) {
            Study study = pQ.poll();

            if (study.status == 's') {
                count++;
                answer = Math.max(answer, count);
            } else {
                count--;
            }
        }
        System.out.println(answer);
    }
}

class Study implements Comparable<Study> {
    int time;
    char status;

    public Study(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Study o) {
        if (this.time == o.time) return this.status - o.status;
        return this.time - o.time;
    }
}