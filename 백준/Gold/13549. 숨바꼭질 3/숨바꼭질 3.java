import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visit;
    static int max = 100000;
    static int min = Integer.MAX_VALUE;

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[max + 1];

        bfs();

        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visit[node.x] = true;
            if (node.x == K) {
                min = Math.min(node.time, min);
            }

            if (node.x * 2 <= max && !visit[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time));
            }
            if (node.x + 1 <= max && !visit[node.x + 1]) {
                q.offer(new Node(node.x +1, node.time + 1));
            }
            if (node.x - 1 >= 0 && !visit[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
            }

        }



    }

}