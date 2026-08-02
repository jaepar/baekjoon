import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int reserved = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    reserved++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    reserved++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        int answer = n - lost.length + reserved;
        
        return answer;
    }
}