import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] bus;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                bus[i][j] = INF;

                if (i == j)
                    bus[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bus[from][to] = Math.min(bus[from][to], weight);
        }

        for (int i = 1; i < N + 1; i++) {                       // 경유지
            for (int j = 1; j < N + 1; j++) {                   // 출발지
                for (int k = 1; k < N + 1; k++) {               // 도착지
                    if (bus[j][k] > bus[j][i] + bus[i][k])
                        bus[j][k] = bus[j][i] + bus[i][k];
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (bus[i][j] == INF) {
                    bus[i][j] = 0;
                }
                sb.append(bus[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}