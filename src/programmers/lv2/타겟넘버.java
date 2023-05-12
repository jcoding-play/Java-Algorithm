package programmers.lv2;

public class 타겟넘버 {

    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    private static void dfs(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, index + 1, sum - numbers[index], target);
        dfs(numbers, index + 1, sum + numbers[index], target);
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }
}
