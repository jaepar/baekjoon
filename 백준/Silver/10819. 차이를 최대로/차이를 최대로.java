import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static int result_max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result_max);
    }

    static void dfs(int depth) {

        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            result_max = Math.max(sum, result_max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }


}