package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 접미사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tmp = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = str.length()-1; i>=0; i--) {
            tmp += str.charAt(i);
            list.add(new StringBuilder(tmp).reverse().toString());
        }

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
