import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int hit = 0;
        int high_rank = 0;
        int low_rank = 0;
        int zero_num = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    hit++;
                }
            }
        }
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_num++;
            }
        }
        
        high_rank = hit + zero_num;
        low_rank = hit;
        
        switch (high_rank) {
            case 6:
                high_rank = 1;
                break;
            case 5:
                high_rank = 2;
                break;
            case 4:
                high_rank = 3;
                break;
            case 3:
                high_rank = 4;
                break;
            case 2:
                high_rank = 5;
                break;
            default:
                high_rank = 6;
        }
        
        switch (low_rank) {
            case 6:
                low_rank = 1;
                break;
            case 5:
                low_rank = 2;
                break;
            case 4:
                low_rank = 3;
                break;
            case 3:
                low_rank = 4;
                break;
            case 2:
                low_rank = 5;
                break;
            default:
                low_rank = 6;
        }
        
        int[] answer = {high_rank, low_rank};
        
        return answer;
    }
}