package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순정렬 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Person> people = initPeople(N);

        people.forEach(person -> System.out.println(person.toString()));
    }

    private static List<Person> initPeople(int N) throws IOException {
        List<Person> people = new ArrayList<>();
        addPerson(N, people);

        Collections.sort(people);
        return people;
    }

    private static void addPerson(int N, List<Person> people) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people.add(new Person(age, name));
        }
    }

    static class Person implements Comparable<Person> {
        private final int age;
        private final String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%d %s", age, name);
        }

        @Override
        public int compareTo(Person other) {
            return this.age - other.age;
        }
    }
}
