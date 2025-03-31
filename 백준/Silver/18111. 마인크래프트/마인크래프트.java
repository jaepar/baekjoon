import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] home;
    static int min_floor = 256;
    static int max_floor = 0;
    static int min_time = Integer.MAX_VALUE;
    static int result_floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        home = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
                if (home[i][j] < min_floor) min_floor = home[i][j];
                if (home[i][j] > max_floor) max_floor = home[i][j];
            }
        }

        calculate();
        System.out.println(min_time + " " + result_floor);
    }

    static void calculate() {
        for (int floor = min_floor; floor <= max_floor; floor++) {
            int time = 0;
            int block = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (floor < home[i][j]) {
                        time += (home[i][j] - floor) * 2;
                        block += home[i][j] - floor;
                    }
                    if (floor > home[i][j]) {
                        time += floor - home[i][j];
                        block -= floor - home[i][j];
                    }
                }
            }
            if (block < 0)  break;

            if (min_time > time) {
                min_time = time;
                result_floor = floor;
            }
            if (min_time == time) {
                if (result_floor < floor) {
                    result_floor = floor;
                }
            }
        }
    }

}