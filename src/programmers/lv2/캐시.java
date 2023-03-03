package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        List<String> list = new ArrayList<>();
        for (String city : cities) {
            city = city.toLowerCase(); //대소문자 구분을 안하기 위해

            if (list.remove(city)) {
                answer += 1;
            } else {
                if (list.size() == cacheSize) {
                    list.remove(0);
                }
                answer += 5;
            }
            list.add(city);
        }
        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(solution(cacheSize, cities));
    }
}
