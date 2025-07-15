import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static int[] dist;

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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            reverseGraph[to].add(new Node(from, weight));
        }

        int result = 0;
        int[] go = algorithm(reverseGraph, X);
        int[] back = algorithm(graph, X);

        for (int i = 1; i <= N; i++) {
            int tmp = go[i] + back[i];

            result = Math.max(result, tmp);
        }
        System.out.println(result);
    }

    static int[] algorithm(ArrayList<Node>[] list, int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.index])
                continue;

            for (Node node : list[cur.index]) {
                if (dist[cur.index] + node.weight < dist[node.index]) {
                    dist[node.index] = dist[cur.index] + node.weight;
                    pq.add(new Node(node.index, dist[node.index]));
                }
            }

        }
        return dist;
    }

}