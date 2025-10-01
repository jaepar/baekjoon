import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] cnt = new int[n][n];
        int[] given = new int[n];
        int[] received = new int[n];
        
        
        Map<String, Integer> names = new HashMap<>();
        for (int i = 0; i < n; i++) {
            names.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = names.get(parts[0]);
            int receiver = names.get(parts[1]);
            
            cnt[giver][receiver]++;
            given[giver]++;
            received[receiver]++;
        }
        
        // 선물 지수 계산
        int[] giftIdx = new int[n];
        for (int i = 0; i < n; i++) {
            giftIdx[i] = given[i] - received[i];
        }
        
        // 다음 달 받을 선물 계산
        int[] nextGift = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int i2j = cnt[i][j];
                int j2i = cnt[j][i];
                
                if (i2j > j2i) {
                    nextGift[i]++;
                }
                else if (j2i > i2j) {
                    nextGift[j]++;
                }
                else { // 같을 경우
                    if (giftIdx[i] > giftIdx[j])
                        nextGift[i]++;
                    else if (giftIdx[j] > giftIdx[i])
                        nextGift[j]++;
                }
            }
        }
        
        int answer = 0;
        for (int num : nextGift) {
            answer = Math.max(num, answer);
        }
        
        return answer;
    }
}