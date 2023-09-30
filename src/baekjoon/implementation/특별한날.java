package baekjoon.implementation;

import java.util.Objects;
import java.util.Scanner;

public class 특별한날 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Date specialDate = new Date(2, 18);
        Date date = initDate(scanner);

        CompareResult result = specialDate.compare(date);

        System.out.println(result.getName());
    }

    private static Date initDate(Scanner scanner) {
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        return new Date(month, day);
    }
}

class Date {
    private final int month;
    private final int day;

    public Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public CompareResult compare(Date date) {
        if (this.equals(date)) {
            return CompareResult.SPECIAL;
        }
        if (date.isMatchMonth(month)) {
            return date.compareWithDay(day);
        }
        return date.compareWithMonth(month);
    }

    private boolean isMatchMonth(int month) {
        return this.month == month;
    }

    private CompareResult compareWithDay(int day) {
        if (this.day > day) {
            return CompareResult.AFTER;
        }
        return CompareResult.BEFORE;
    }

    private CompareResult compareWithMonth(int month) {
        if (this.month > month) {
            return CompareResult.AFTER;
        }
        return CompareResult.BEFORE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day);
    }
}

enum CompareResult {
    BEFORE("Before"),
    AFTER("After"),
    SPECIAL("Special");

    private final String name;

    CompareResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}