import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int home[][] = new int[N + 1][3];
        int dp[][] = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = home[1][0];
        dp[1][1] = home[1][1];
        dp[1][2] = home[1][2];

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }

}