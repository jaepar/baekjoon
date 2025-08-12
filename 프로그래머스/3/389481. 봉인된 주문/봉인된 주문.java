import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        long[] bansNum = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            bansNum[i] = stringToNum(bans[i]);
        }
        
        Arrays.sort(bansNum);
        for (long banNum : bansNum) {
            if (banNum <= n)
                n++;
        }
        
        answer = numToString(n);
        
        return answer;
    }
    
    private long stringToNum(String str) {
        long num = 0;
        int length = str.length();
        
        for(int i = 0; i < length; i++) {
            num += (str.charAt(i) - 96) * Math.pow(26, length - 1 - i);
        }
        
        return num;
    }
    
    private String numToString(long num) {
        String str = "";
        
        while(num > 0) {
            str = String.valueOf((char)((num - 1) % 26 + 1 + 96)) + str;
            num = (num - 1) / 26;
        }
        
        return str;
    }
    
}