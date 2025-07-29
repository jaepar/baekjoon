class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int height = (num - 1) / w + 1;
        int width = (height % 2 == 0) ? (w * height) - num + 1 : (num - 1) % w + 1;
        
        int cur = num;
        
        while (cur <= n) {
            answer++;
            
            if ((height + answer) % 2 == 0) {
                cur += (w * 2) - (width * 2 - 1);
            }
            else {
                cur += width * 2 - 1;
            }
            
        }
        
        return answer;
    }
}