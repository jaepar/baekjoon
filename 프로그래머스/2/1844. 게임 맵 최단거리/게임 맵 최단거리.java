import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        
        return(bfs(0, 0, maps));
    }
    
    private int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];
            
            if (curX == n - 1 && curY == m - 1){
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if (maps[nx][ny] == 0) {
                    continue;
                }
                
                if (visit[nx][ny]) {
                    continue;
                }
                
                q.add(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
            }
        }
        return -1;
    }
    
}