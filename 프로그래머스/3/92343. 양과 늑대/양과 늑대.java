import java.util.*;

class Solution {
    int answer = 0;
    int[] info;
    List<Integer>[] child;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        this.info = info;
        
        child = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            child[e[0]].add(e[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        
        dfs(0, 0, candidates);
        
        return answer;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> candidates) {
        answer = Math.max(answer, sheep);
        
        for (int i = 0; i < candidates.size(); i++) {
            int node = candidates.get(i);
            
            int sCnt = sheep + (info[node] == 0 ? 1 : 0);
            int wCnt = wolf + (info[node] == 1 ? 1 : 0);
            if (sCnt <= wCnt)
                continue;
            
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);
            nextCandidates.addAll(child[node]);
            
            dfs(sCnt, wCnt, nextCandidates);
        }
        
    }
    
}