package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file = stringToFile(files[i], i);
            fileList.add(file);
        }

        Collections.sort(fileList);
        int i = 0;
        for (File file : fileList) {
            answer[i++] = fileToString(file);
        }
        return answer;
    }

    private static File stringToFile(String file, int index) {
        String head = "";
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                head = file.substring(0, i);
                file = file.substring(i);
                break;
            }
        }

        String number = "";
        for (int i = 0; i < file.length(); i++) {
            if (i == 5 || !Character.isDigit(file.charAt(i))) {
                number = file.substring(0, i);
                file = file.substring(i);
                break;
            }
            if (i == file.length() - 1) {
                number = file;
                file = "";
            }
        }

        String tail = "";
        if (file.length() > 0) tail = file;

        return new File(head, number, tail, index);
    }

    private static String fileToString(File file) {
        return file.head + file.number + file.tail;
    }

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;
        int index;

        public File(String head, String number, String tail, int index) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.equalsIgnoreCase(o.head) && Integer.parseInt(this.number) == Integer.parseInt(o.number)) return this.index - o.index;
            if (this.head.equalsIgnoreCase(o.head)) return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            return this.head.compareToIgnoreCase(o.head);
        }
    }

    public static void main(String[] args) {
        String[] files = {"F-5 Freedom Fighter", "B-50", "A-10 Thunderbolt II", "F-14 Tomcat"};
        for (String str : solution(files)) {
            System.out.println(str);
        }
    }
}
