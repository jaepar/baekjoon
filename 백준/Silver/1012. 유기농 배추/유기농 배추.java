import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K;
    static int[][] farm;
    static boolean[][] visit;
    static int count;

    static int[] side_x = {-1, 1, 0, 0};
    static int[] side_y = {0, 0, -1, 1};
    static int now_x, now_y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                StringTokenizer st_K = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st_K.nextToken());
                int y = Integer.parseInt(st_K.nextToken());

                farm[x][y] = 1;
            }

            count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (farm[j][k] == 1 && !visit[j][k]) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            now_x = x + side_x[i];
            now_y = y + side_y[i];

            if (now_x < M && now_x >= 0 && now_y < N && now_y >= 0) {
                if (farm[now_x][now_y] == 1 && !visit[now_x][now_y]) {
                    dfs(now_x, now_y);
                }
            }
        }
    }

}