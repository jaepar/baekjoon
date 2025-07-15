import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reversGraph;
    static int INF = 1000000;

    static class Node implements Comparable<Node> {
        int index, weight;

        public Node(int index, int weight){
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
        reversGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reversGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            reversGraph[to].add(new Node(from, weight));
        }

        // X에서 각 마을로
        int[] go = algorithm(graph, X);
        // 각 마을에서 X로
        int[] back = algorithm(reversGraph, X);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = go[i] + back[i];

            if (tmp > result) {
                result = tmp;
            }
        }

        System.out.println(result);
    }

    static int[] algorithm(ArrayList<Node>[] list ,int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
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