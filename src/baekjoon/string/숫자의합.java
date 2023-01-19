package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int read = br.read();
            //BufferedReader 클래스에 read() 메서드는 스트림의 문자를 하나 읽는다.
            //그렇기 때문에 받아온 스트림 문자 값에 -48 또는 -'0' 을 해줘야 원하는 숫자를 읽을 수 있다.
            sum += read - '0';
        }
        System.out.println(sum);
    }
}
