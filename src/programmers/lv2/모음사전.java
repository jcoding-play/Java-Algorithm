package programmers.lv2;

public class 모음사전 {

    static int result = 0;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static boolean flag = false;

    public static int solution(String word) {
        dfs("", word);
        return result;
    }

    private static void dfs(String tmp, String word) {
        if (flag || tmp.length() > 5) {
            return;
        }
        if (tmp.equals(word)) {
            flag = true;
            return;
        }

        result++;
        for (int i = 0; i < 5; i++) {
            dfs(tmp + alphabet[i], word);
        }
    }

    public static void main(String[] args) {
        String word = "EIO";
        System.out.println(solution(word));
    }
}
