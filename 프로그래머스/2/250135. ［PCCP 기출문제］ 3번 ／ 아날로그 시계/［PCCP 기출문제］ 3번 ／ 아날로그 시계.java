class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int startSec = parseToSec(h1, m1, s1);
        int endSec = parseToSec(h2, m2, s2);
        
        answer = func(endSec) - func(startSec);
        answer += func2(startSec) ? 1 : 0;
        
        return answer;
    }
    
    private int parseToSec(int hour, int min, int sec) {
        return hour * 60 * 60 + min * 60 + sec;
    }
    
    private int func(int sec) {
        int minAlarm = sec * 59 / 3600;
        int hourAlarm = sec * 719 / 43200;
        
        int duplicate = 43200 <= sec ? 2 : 1;
        
        return minAlarm + hourAlarm - duplicate;
    }
    
    private boolean func2(int sec) {
        return sec * 59 / 3600 == 0 || sec * 719 % 43200 == 0;
    }
    
}