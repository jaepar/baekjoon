import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer A[] = new Integer[N];
        Integer B[] = new Integer[N];

        StringTokenizer st_A = new StringTokenizer(br.readLine());
        StringTokenizer st_B = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st_A.nextToken());
            B[i] = Integer.parseInt(st_B.nextToken());
        }

        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순 정렬

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}