package programmers.lv2;

public class 이진변환반복하기 {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int deleteZero = 0;
        while (!s.equals("1")) {
            int lenWithZero = s.length();
            s = s.replaceAll("0", "");
            int lenWithoutZero = s.length();
            deleteZero += lenWithZero - lenWithoutZero;

            s = Integer.toBinaryString(lenWithoutZero);
            count++;
        }
        answer[0] = count;
        answer[1] = deleteZero;
        return answer;
    }

    public static void main(String[] args) {
        String s = "1111111";
        for (int x : solution(s)) {
            System.out.print(x + " ");
        }
    }
}
