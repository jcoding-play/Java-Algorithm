package programmers.lv2;

public class JadenCase문자열만들기 {
    public static String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        char[] tmp = s.toCharArray();
        char last = ' ';
        for (int i = 0; i < tmp.length; i++) {
            if (last == ' ' && Character.isAlphabetic(tmp[i])) {
                tmp[i] = Character.toUpperCase(tmp[i]);
            }
            last = s.charAt(i);
        }

        return answer = String.valueOf(tmp);
    }

    public static void main(String[] args) {
        String s = "for the last week";
        System.out.println(solution(s));
    }
}
