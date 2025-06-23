import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int x1, y1, x2, y2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j <= x2; j++) {
                sum += map[j][y2] - map[j][y1 - 1];
            }
            bw.write(sum + "\n");
        }

        bw.flush();
    }

}