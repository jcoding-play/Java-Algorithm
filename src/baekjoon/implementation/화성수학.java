package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class 화성수학 {
    private static Map<String, Function<Double, Double>> store = new HashMap<>();

    static {
        store.put("@", number -> number * 3);
        store.put("%", number -> number + 5);
        store.put("#", number -> number - 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            double number = Double.parseDouble(tokenizer.nextToken());
            number = calculate(tokenizer, number);

            builder.append(String.format("%.2f", number))
                    .append('\n');
        }

        System.out.print(builder);
    }

    private static double calculate(StringTokenizer st, double number) {
        while (st.hasMoreTokens()) {
            number = calculate(number, st.nextToken());
        }

        return number;
    }

    private static double calculate(double number, String operator) {
        return store.get(operator).apply(number);
    }
}
