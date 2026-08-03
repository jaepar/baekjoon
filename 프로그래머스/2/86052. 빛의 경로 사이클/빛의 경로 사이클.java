import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dir;
    static boolean[][][] visited;
    static int DIR_NUM = 4;
    static int r, c;
    static List<Integer> result = new ArrayList<>();
    
    public int[] solution(String[] grid) {
        r = grid.length;
        c = grid[0].length();        
        dir = new int[r][c];
        visited = new boolean[r][c][DIR_NUM];
        
        init(grid);
        
        move();
        
        Collections.sort(result);
        
        int[] answer = result.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
    
    private void move() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < DIR_NUM; k++) {
                    if (!visited[i][j][k]) {
                        result.add(checkCycle(i, j, k));
                    }
                }
            }
        }
    }
    
    private int checkCycle(int x, int y, int d) {
        int cnt = 0;
        int nowX = x;
        int nowY = y;
        int nowD = d;
        
        while (true) {
            if (visited[nowX][nowY][nowD])
                break;
            
            cnt++;
            visited[nowX][nowY][nowD] = true;
            
            int nx = (nowX + dx[nowD] + r) % r;
            int ny = (nowY + dy[nowD] + c) % c;
            int nd = (nowD + dir[nx][ny] + DIR_NUM) % DIR_NUM;
            
            nowX = nx;
            nowY = ny;
            nowD = nd;
        }
        return cnt;
    }
    
    private void init(String[] grid) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i].charAt(j) == 'S') {
                    dir[i][j] = 0;
                }
                else if (grid[i].charAt(j) == 'L') {
                    dir[i][j] = -1;
                }
                else {
                    dir[i][j] = 1;
                }
            }
        }
    }
    
}