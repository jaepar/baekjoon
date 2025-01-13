import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st_D = new StringTokenizer(br.readLine());
        long[] D = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            D[i] = Integer.parseInt(st_D.nextToken());
        }

        StringTokenizer st_P = new StringTokenizer(br.readLine());
        long[] P = new long[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st_P.nextToken());
        }

        long oil = 0;
        long min = P[0];
        for (int i = 0; i < N - 1; i++) {
            if (P[i] < min) {
                min = P[i];
            }
            oil += (min * D[i]);
        }

        bw.write(String.valueOf(oil));
        bw.flush();
    }
}