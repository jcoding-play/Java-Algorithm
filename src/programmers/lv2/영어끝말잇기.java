package programmers.lv2;

import java.util.ArrayList;

public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        char last = ' ';
        int i;
        for (i = 0; i < words.length; i++) {
            if (list.size() == 0) {
                if (!checkLength(words[i])) {
                    break;
                }
            } else {
                if(!checkLength(words[i]) ||
                        words[i].charAt(0)!=last ||
                        list.contains(words[i])) {
                    break;
                }
            }
            list.add(words[i]);
            last = words[i].charAt(words[i].length() - 1);
        }

        if (i != words.length) {
            i++;
            int x = i % n;
            int y = i / n;

            if(x>0) y++;
            if(x==0) x = n;

            answer[0] = x;
            answer[1] = y;
        }
        return answer;
    }

    private static boolean checkLength(String word) {
        return 2 <= word.length() && word.length() <= 50;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        for (int x : solution(n, words)) {
            System.out.print(x + " ");
        }
    }
}
