import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int startLevel = 1;
        int endLevel = 100000;
        
        while(startLevel <= endLevel){
            int level = (endLevel + startLevel) / 2;
            long time = getTime(diffs, times, level);
            
            if(time <= limit){
                answer = level;
                endLevel = level - 1;
            }
            else{
                startLevel = level + 1;
            }
            
        }
        return answer;
    }
    
    private long getTime(int[] diffs, int[] times, int level){
        long time = 0;
        
        for(int i = 0; i < diffs.length; i++){
            int tryCount = diffs[i] - level;
            
            if(tryCount <= 0){
                time += times[i];
                continue;
            }
            
            if(i == 0){
                time += ((long) times[i] * tryCount) + times[i];
            }
            else{
                time += ((long) times[i] + (long) times[i-1]) * tryCount + times[i];
            }
            
        }
        return time;
    }
    
}