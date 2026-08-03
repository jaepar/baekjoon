class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int chance = 0;
        
        for (int i = 0; i < number.length(); i++) {
            
            while (chance < k
                    && sb.length() > 0
                    && number.charAt(i) > sb.charAt(sb.length() - 1)) {
                
                chance++;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(number.charAt(i));
        }
        
        return sb.substring(0, number.length() - k);
    }
}