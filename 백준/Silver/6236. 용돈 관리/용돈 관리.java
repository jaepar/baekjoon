import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        day = new int[N];
        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, day[i]);
            sum += day[i];
        }

        int left = max;
        int right = sum;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean check(int K) {
        int count = 1;
        int money = K;

        for (int i = 0; i < N; i++) {
            if (day[i] > K)
                return false;

            if (money < day[i]) {
                count++;
                money = K;
            }

            money -= day[i];
        }

        return count <= M;
    }

}