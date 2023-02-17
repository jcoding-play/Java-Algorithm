package programmers.lv2;

public class 올바른괄호 {
    static boolean solution(String s) {
        boolean answer = true;
        char[] c = new char[s.length()];
        int lt = 0;
        for (char tmp : s.toCharArray()) {
            if (tmp == '(') {
                c[lt++] = tmp;
            } else {
                lt--;
                if(lt<0) return false;
                c[lt] = ' ';
            }
        }

        if (c[0] == '(') {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }
}
