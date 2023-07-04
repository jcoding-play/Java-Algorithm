package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 생일 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Person> people = initializePeople(br, n);

        printNameOfYoungestPerson(people);
        printNameOfOldestPerson(people);
    }

    private static List<Person> initializePeople(BufferedReader br, int n) throws IOException {
        List<Person> people = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            Date date = initializeDate(st);
            people.add(new Person(name, date));
        }
        return people;
    }

    private static Date initializeDate(StringTokenizer st) {
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        return new Date(day, month, year);
    }

    private static void printNameOfYoungestPerson(List<Person> people) {
        people.stream()
                .min(Person::compareTo)
                .ifPresent(person -> System.out.println(person.getName()));
    }

    private static void printNameOfOldestPerson(List<Person> people) {
        people.stream()
                .max(Person::compareTo)
                .ifPresent(person -> System.out.println(person.getName()));
    }

    static class Person implements Comparable<Person> {
        private final String name;
        private final Date date;

        public Person(String name, Date date) {
            this.name = name;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person other) {
            return this.date.compareTo(other.date);
        }
    }

    static class Date implements Comparable<Date> {
        private final int day;
        private final int month;
        private final int year;

        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Date other) {
            if (this.year == other.year && this.month == other.month) {
                return other.day - this.day;
            }
            if (this.year == other.year) {
                return other.month - this.month;
            }
            return other.year - this.year;
        }
    }
}
