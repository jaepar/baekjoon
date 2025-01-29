import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = 0;

        for (int i = 1; i < K + 1; i++) {
            min += i;
        }

        if (min > N) {
            System.out.println(-1);
        } else {
            int answer = K - 1;
            N -= min;
            if (N % K != 0) {
                answer++;
            }
            System.out.println(answer);
        }

    }


}