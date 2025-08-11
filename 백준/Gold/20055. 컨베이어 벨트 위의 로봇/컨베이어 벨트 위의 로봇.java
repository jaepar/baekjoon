import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N + 1];
        robots = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;

        while (true) {
            // 1번 과정
            int tmp = A[2 * N];

            for (int i = 2 * N; i > 1; i--) {
                A[i] = A[i - 1];
            }
            A[1] = tmp;

            for (int i = N; i > 1; i--) {
                robots[i] = robots[i - 1];
            }
            robots[1] = false;

            robotDown();

            // 2번 과정
            for (int i = N - 1; i > 1; i--) {
                if (robots[i] && !robots[i + 1] && A[i + 1] > 0) {
                    A[i + 1]--;
                    robots[i] = false;
                    robots[i + 1] = true;
                }
            }

            robotDown();

            // 3번 과정
            if (A[1] > 0) {
                A[1]--;
                robots[1] = true;
            }

            // 4번 과정
            int zeroCnt = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] == 0) {
                    zeroCnt++;
                }
            }

            if (zeroCnt >= K) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    static private void robotDown() {
        if (robots[N]) {
            robots[N] = false;
        }
    }

}