import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int N = 0;
        for (int i = 0; i < edges.length; i++) {
            N = Math.max(N, Math.max(edges[i][0], edges[i][1]));
        }
        
        int[] outLine = new int[N + 1];
        int[] inLine = new int[N + 1];
        
        for (int[] edge : edges) {
            outLine[edge[0]]++;
            inLine[edge[1]]++;
        }
        
        int root = 0;
        int stick = 0;
        int eight = 0;
        
        for (int i = 1; i < N + 1; i++) {
            if (outLine[i] >= 2){
                if(inLine[i] == 0)
                    root = i;
                else
                    eight++;
            }
            else if(outLine[i] == 0 && inLine[i] >= 1)
                stick++;
        }
        
        int[] answer = {root, (outLine[root] - stick - eight), stick, eight};
        
        return answer;
    }
}