import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer T[] = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T);
        int sum = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            sum += prev + T[i];
            prev += T[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}