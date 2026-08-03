import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        
        return find(parent[node]);
    }
    
    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
}