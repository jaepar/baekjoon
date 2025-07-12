import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int N, E, V1, V2;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static int MAX_VALUE = 200000000;

    static class Node implements Comparable<Node> {
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += algorithm(1, V1);
        result1 += algorithm(V1, V2);
        result1 += algorithm(V2, N);

        int result2 = 0;
        result2 += algorithm(1, V2);
        result2 += algorithm(V2, V1);
        result2 += algorithm(V1, N);

        int result = (result1 >= MAX_VALUE && result2 >= MAX_VALUE) ? -1 : Math.min(result1, result2);

        System.out.println(result);
    }

    static int algorithm(int start, int to) {
        Arrays.fill(dist, MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.index])
                continue;

            for (Node node : graph[cur.index]) {
                if (dist[cur.index] + node.weight < dist[node.index]) {
                    dist[node.index] = dist[cur.index] + node.weight;
                    pq.add(new Node(node.index, dist[node.index]));
                }
            }

        }
        return dist[to];
    }

}