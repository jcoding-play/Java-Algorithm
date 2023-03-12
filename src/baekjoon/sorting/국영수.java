package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] person = new Person[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            person[i] = new Person(name, korean, english, math);
        }

        Arrays.sort(person, (o1, o2) -> {
            if(o2.korean == o1.korean && o2.english == o1.english && o2.math == o1.math) return o1.name.compareTo(o2.name);
            if(o2.korean == o1.korean && o2.english == o1.english) return o2.math - o1.math;
            if (o2.korean == o1.korean) return o1.english - o2.english;
            return o2.korean - o1.korean;
        });
        StringBuilder sb = new StringBuilder();
        Iterator<Person> iterator = Arrays.stream(person).iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().name).append('\n');
        }
        System.out.print(sb);
    }

    static class Person {
        String name;
        int korean;
        int english;
        int math;

        public Person(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
