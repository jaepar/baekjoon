import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        result[1] = 1;
        int max = 1;
        for (int i = 2; i < N + 1; i++) {
            result[i] = 1;

            for (int j = 1; j < i; j++) {
                if (num[j] < num[i] && result[j] >= result[i]) {
                    result[i] = result[j] + 1;
                }
            }

            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }

}