class Solution {
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    private void dfs(int x, int[][] computers) {
        visit[x] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visit[i] && computers[x][i] == 1) {
                dfs(i, computers);
            }
        }
    }
    
}