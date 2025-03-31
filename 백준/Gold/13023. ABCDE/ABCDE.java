import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] friend;
    static boolean[] visited;
    static boolean status;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(1, i);
            if (status) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }

    static void dfs(int depth, int start) {
        if (depth == 5) {
            status = true;
            return;
        }

        visited[start] = true;
        for (int v : friend[start]) {
            if (!visited[v]) {
                dfs(depth + 1, v);
            }
        }
        visited[start] = false;

    }
}