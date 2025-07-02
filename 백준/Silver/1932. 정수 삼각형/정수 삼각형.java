import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static Integer[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        algorithm(0, 0);

        System.out.println(dp[0][0]);
    }

    static int algorithm(int depth, int index) {

        if (depth == N - 1) {
            return dp[depth][index];
        }

        if (dp[depth][index] == null) {
            dp[depth][index] = Math.max(algorithm(depth + 1, index), algorithm(depth + 1, index + 1)) + arr[depth][index];
        }

        return dp[depth][index];
    }

}