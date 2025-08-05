import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[] oil; 
    
    static class Node {
        int x, y;
        
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        visit = new boolean[n][m];
        oil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    private void bfs(int x, int y, int[][] land) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x, y));
        visit[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            set.add(cur.y);
            
            for (int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                
                if (land[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    count += 1;
                    q.add(new Node(nx, ny));
                }
            }
        }
        
        for (int index : set) {
            oil[index] += count;
        }
        
    }
    
}