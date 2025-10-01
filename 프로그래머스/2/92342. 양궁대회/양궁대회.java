import java.util.*;

class Solution {
    static int n;
    static int[] info;
    static int[] answer;
    static int[] cur = new int[11];
    static int maxDiff = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        this.answer = new int[]{-1};
        
         dfs(0, n, 0, 0);
            
        return answer;
    }
    
    private void dfs(int idx, int remain, int rScore, int aScore) {
        if (idx == 11) {
            int diff = rScore - aScore;
            if(diff <= 0)
                return;
            
            if (answer[0] == -1 || diff > maxDiff || (diff == maxDiff && tiebreaker(cur, answer))) {
                maxDiff = diff;
                answer = Arrays.copyOf(cur, 11);
            }
            return;
        }
        
        if (idx == 10) {
            cur[idx] = remain; // 남은 화살은 전부 0점에 몰아박기
            dfs(idx + 1, 0, rScore, aScore);
            cur[idx] = 0;
            return;
        }
        
        int score = 10 - idx;
        
        // 라이언이 점수를 가져가는 경우
        int need = info[idx] + 1;
        if (remain >= need) {
            cur[idx] = need;
            dfs(idx + 1, remain - need, rScore + score, aScore);
            cur[idx] = 0;
        }
        
        // 라이언이 점수를 포기하는 경우
        if (info[idx] > 0)
            aScore += score;
        cur[idx] = 0;
        dfs(idx + 1, remain, rScore, aScore);
        
    }
    
    private boolean tiebreaker(int[] cur, int[] answer) {
        for (int i = 10; i >= 0; i--) {
            if (cur[i] != answer[i])
                return cur[i] > answer[i];
        }
        return false;
    }
    
}