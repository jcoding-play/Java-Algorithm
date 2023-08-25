package baekjoon.implementation;

public class 정수N개의합 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long result = sum(a);
        System.out.println("result = " + result);
    }

    private static long sum(int[] a) {
        long sum = 0;

        for (int number : a) {
            sum += number;
        }

        return sum;
    }
}
