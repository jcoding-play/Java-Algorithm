package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * MyInteger라는 별도 class를 만든 풀이
 */
public class 절대값힙_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<MyInteger> pQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pQ.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pQ.poll().x).append("\n");
                }
            } else {
                pQ.offer(new MyInteger(x));
            }
        }
        System.out.print(sb);
    }
}

class MyInteger implements Comparable<MyInteger> {
    int x;

    public MyInteger(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(MyInteger o) {
        if(Math.abs(this.x)==Math.abs(o.x)) return this.x - o.x;
        return Math.abs(this.x)-Math.abs(o.x);
    }
}