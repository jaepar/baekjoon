import java.util.*;

class Solution {
    
    public class Point implements Comparable<Point> {
        int node, weight;
        
        public Point(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }
    
    static ArrayList<Point>[] map;
    
    public int solution(int n, int[][] costs) {
        
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            
            map[from].add(new Point(to, weight));
            map[to].add(new Point(from, weight));
        }
        
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0));
        
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            
            if (visited[cur.node])
                continue;
            visited[cur.node] = true;
            answer += cur.weight;
            
            for (int i = 0; i < map[cur.node].size(); i++) {
                
                int next = map[cur.node].get(i).node;
                int weight = map[cur.node].get(i).weight;
                
                if (visited[next])
                    continue;
                pq.add(new Point(next, weight));
            }
        }
        return answer;
    }
}