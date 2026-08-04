import java.util.*;

class Solution {
    static int[][] arr = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        draw(rectangle);
        
        int answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;
    }
    
    private int bfs(int startX, int startY, int goalX, int goalY) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{startX, startY, 0});
        visited[startY][startX] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];
            
            if (curX == goalX && curY == goalY) {
                return curD / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx >= 1 && ny >= 1 && nx <= 100 && ny <= 100
                   && !visited[ny][nx] && arr[ny][nx] == 1) {
                    q.add(new int[]{nx, ny, curD + 1});
                    visited[ny][nx] = true;
                }
                
            }
        }
        return -1;
    }
    
    private void draw(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (j == x1 || j == x2 || k == y1 || k == y2) {
                        if (arr[k][j] == 2)
                            continue;
                        
                        arr[k][j] = 1;
                    }
                    else {
                        arr[k][j] = 2;
                    }
                }
            }
            
        }
    }
    
}