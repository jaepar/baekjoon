import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int car = routes.length;
        int cam = Integer.MIN_VALUE;
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for (int i = 0 ; i < car; i++) {
            if (cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}