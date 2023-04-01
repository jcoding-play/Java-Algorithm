package programmers.lv2;

import java.util.*;

public class 주차요금계산 {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer> totalTime = new TreeMap<>();

        Map<String, String> map = new HashMap<>();
        for (String record : records) {
            String[] tmp = record.split(" ");

            if (tmp[2].equals("IN")) {
                map.put(tmp[1], tmp[0]);
            } else {
                String inTime = map.get(tmp[1]);

                int parkingTime = getParkingTime(tmp[0], inTime);
                map.remove(tmp[1]);
                totalTime.put(tmp[1], totalTime.getOrDefault(tmp[1], 0) + parkingTime);
            }
        }
        if (!map.isEmpty()) {
            map.forEach((key, value) -> {
                int parkingTime = getParkingTime("23:59", value);
                totalTime.put(key, totalTime.getOrDefault(key, 0) + parkingTime);
            });
        }

        answer = new int[totalTime.size()];
        int i = 0;
        for (Integer value : totalTime.values()) {
            answer[i++] = fees[1] + calculateOverTimePrice(value, fees);
        }
        return answer;
    }

    private static int getParkingTime(String outTime, String inTime) {
        return hourToMinute(outTime) - hourToMinute(inTime);
    }

    private static int hourToMinute(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]);
        int minute = Integer.parseInt(tmp[1]);

        return (hour * 60) + minute;
    }

    private static int calculateOverTimePrice(int parkingTime, int[] fees) {
        int result = RoundUp(parkingTime, fees[0], fees[2]);

        return result * fees[3];
    }

    private static int RoundUp(int parkingTime, int baseTime, int unitTime) {
        if (parkingTime <= baseTime) return 0;

        int overTime = parkingTime - baseTime;
        int result = overTime / unitTime;

        if (overTime % unitTime > 0) {
            return result + 1;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        for (int x : solution(fees, records)) {
            System.out.println(x);
        }
    }
}
