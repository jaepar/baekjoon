import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        String word;

        Scanner sc = new Scanner(System.in);

        // 단어 개수입력
        while (true) {
            n = sc.nextInt();
            sc.nextLine();
            if(n >= 1 && n <= 20000)
                break;
        }
        String words[] = new String[n];

        // 문자열(단어) 입력
        int m = 0;
        while (m < n) {
            word = sc.nextLine().trim();
            if(word.length() > 50) {
                continue;
            }
            words[m] = word;
            m++;
        }

        // 정렬
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        // 중복제거된 문자열 출력
        System.out.println(words[0]);
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }

    }
}