import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static List<List<Node>> graph;
    static int[] dist;

    static class Node {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end <= D) {
                graph.get(start).add(new Node(end, length));
            }
        }

        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        algorithm();
        System.out.println(dist[D]);
    }

    static void algorithm() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.to]) continue;

            if (cur.to + 1 <= D && dist[cur.to] + 1 < dist[cur.to + 1]) {
                dist[cur.to + 1] = dist[cur.to] + 1;
                pq.add(new Node(cur.to + 1, dist[cur.to + 1]));
            }

            for (Node next : graph.get(cur.to)) {
                if (dist[cur.to] + next.weight < dist[next.to]) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}