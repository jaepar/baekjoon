import java.util.*;

class Solution {
    int n, m, r, c, k;
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    StringBuilder sb = new StringBuilder();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n; this.m = m; this.r = r; this.c = c; this.k = k;
        
        int dist = Math.abs(r - x) + Math.abs(c - y);
        
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }
        
        boolean flag = dfs(x, y, 0);
        
        return flag ? sb.toString() : "impossible";
    }
    
    private boolean dfs(int x, int y, int depth) {
        if (depth == k)
            return x == r && y == c;
        
        int remain = k - depth - 1;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > n || ny > m || nx < 1 || ny < 1)
                continue;
            
            int need = Math.abs(nx - r) + Math.abs(ny - c);
            
            if (need <= remain && (remain - need) % 2 == 0) {
                sb.append(dir[i]);
                if (dfs(nx, ny, depth + 1))
                    return true;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}