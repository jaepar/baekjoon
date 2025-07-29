class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            if (func(schedules[i], timelogs[i], startday))
                answer++;
        }
        
        return answer;
    }
    
    private boolean func(int schedule, int[] timelog, int startday){
        int hour = schedule / 100;
        int min = schedule % 100;
        
        min += 10;
        if (min >= 60){
            hour++;
            min -= 60;
        }
        
        int limitTime = hour * 100 + min;
        
        for (int i = 0; i < timelog.length; i++){
            if (startday == 6 || startday == 7){
                startday = (startday % 7) + 1;
                continue;
            }
            
            if (timelog[i] > limitTime) {
                return false;
            }
            
            startday = startday + 1;
        }
        return true;
    }
    
}