package programmers.lv2;

public class 피로도 {

    static int[] ch;
    static int answer = -1;

    public static int solution(int k, int[][] dungeons) {
        ch = new int[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private static void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (ch[i] == 0 && k >= dungeons[i][0]) {
                ch[i] = 1;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }
}
