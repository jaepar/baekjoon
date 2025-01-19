import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] pass;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            pass = new int[N + 1];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                pass[a] = b;
            }

            int standard = pass[1];
            int count = 1;

            for (int k = 2; k < N + 1; k++) {
                if (pass[k] < standard) {
                    count++;
                    standard = pass[k];
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}