import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static ArrayList<Integer>[] edge;
    static int[] color;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edge = new ArrayList[V + 1];
            color = new int[V + 1];

            for (int k = 1; k < V + 1; k++) {
                edge[k] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edge[u].add(v);
                edge[v].add(u);
            }

            boolean result = false;
            for (int m = 1; m < V + 1; m++) {
                if (color[m] == 0) {
                    result = bfs(m);
                }
                if (!result) {
                    break;
                }
            }
            if (result) sb.append("YES").append("\n");
            if (!result) sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        color[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i : edge[temp]) {
                if (color[i] == 0) {
                    color[i] = color[temp] * -1;
                    q.add(i);
                } else if (color[i] == color[temp]) {
                    return false;
                }
            }

        }
        return true;
    }

}