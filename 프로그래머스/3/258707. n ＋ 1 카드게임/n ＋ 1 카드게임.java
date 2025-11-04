import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        
        int n = cards.length;
        int idx = n / 3;
        int goal = n + 1;
        
        Set<Integer> my_cards = new HashSet<>();
        
        for (int i = 0; i < idx; i++) {
            my_cards.add(cards[i]);
        }
        
        Set<Integer> new_cards = new HashSet<>();
        
        while (true) {
            if (idx >= n) {
                break;
            }
            
            new_cards.add(cards[idx]);
            new_cards.add(cards[idx + 1]);
            
            idx += 2;
            
            boolean flag = true;
            // 1. 새로운 카드를 가지지 않고서 기존 카드로 n+1 조합 완성
            for(int num : my_cards) {
                if (my_cards.contains(goal - num)) {
                    my_cards.remove(num);
                    my_cards.remove(goal - num);
                    flag = false;
                    break;
                }
            }
            
            // 2. 새로운 카드 1장을 가지고서 n+1 조합 완성
            if (flag) {
                if (coin >= 1) {
                    for (int num : my_cards) {
                        if (new_cards.contains(goal - num)) {
                            my_cards.remove(num);
                            new_cards.remove(goal - num);
                            coin--;
                            flag = false;
                            break;
                        }
                    }
                }
            }
            
            // 3. 새로운 카드 2장을 가지고서 n+1 조합 완성
            if (flag) {
                if (coin >= 2) {
                    for (int num : new_cards) {
                        if (new_cards.contains(goal - num)){
                            new_cards.remove(num);
                            new_cards.remove(goal - num);
                            coin -= 2;
                            flag = false;
                            break;   
                        }
                    }
                }
            }
            
            // 조건에 부합하지 않다면 while문 탈출
            if (flag) {
                break;
            }
            answer ++;
        }
        
        return answer;
    }
}