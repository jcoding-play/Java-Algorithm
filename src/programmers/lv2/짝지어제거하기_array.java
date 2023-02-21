package programmers.lv2;

public class 짝지어제거하기_array {
    public static int solution(String s) {
        int answer = 0;
        int lt = 0;
        char[] tmp = new char[s.length()];
        char last = ' ';
        for (char c : s.toCharArray()) {
            if (c != last) {
                tmp[lt++] = c;
                last = c;
            } else {
                if (lt >= 2) {
                    last = tmp[lt - 2];
                    lt -= 1;
                } else {
                    last = ' ';
                    lt = 0;
                }
            }
        }
        if(lt==0) answer = 1;
        return answer;
    }

    public static void main(String[] args) {
        String s = "cdcd";
        System.out.println(solution(s));
    }
}
