import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] edge;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edge = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x].add(y);
            edge[y].add(x);
        }

        bfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i : edge[temp]) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                    parent[i] = temp;
                }
            }

        }


    }

}