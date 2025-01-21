import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] box;
    static int[] side_x = {-1, 1, 0, 0};
    static int[] side_y = {0, 0, -1, 1};
    static int day = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st_t = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st_t.nextToken());
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();

        if (check()) {
            System.out.println(day - 1);
        } else
            System.out.println(-1);

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i = 0; i < 4; i++) {
                int now_x = x + side_x[i];
                int now_y = y + side_y[i];

                if (now_x >= 0 && now_y >= 0 && now_x < N && now_y < M) {
                    if (box[now_x][now_y] == 0) {
                        box[now_x][now_y] = box[x][y] + 1;
                        q.add(new int[]{now_x, now_y});
                    }
                }
            }

        }

    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false;
                day = Math.max(day, box[i][j]);
            }
        }
        return true;
    }

}