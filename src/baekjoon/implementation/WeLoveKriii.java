package baekjoon.implementation;

public class WeLoveKriii {
    public static final String NEWLINE = System.lineSeparator();
    public static final String MESSAGE = "강한친구 대한육군";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(MESSAGE).
                append(NEWLINE).
                append(MESSAGE);
        System.out.println(sb);
    }
}
