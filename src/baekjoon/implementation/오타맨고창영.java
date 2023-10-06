package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오타맨고창영 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String result = modify(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken());

            builder.append(result)
                    .append(System.lineSeparator());
        }
        
        System.out.print(builder);
    }

    protected static String modify(int position, String input) {
        int index = position - 1;
        String[] inputs = input.split("");

        inputs[index] = "";

        return String.join("", inputs);
    }
}
