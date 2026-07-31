import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        
        if (!set.contains(target)) {
            return 0;
        }
        
        q.offer(begin);
        
        while(!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return answer;
                }
                
                for (String word : set.toArray(new String[set.size()])) {
                    if (canConvert(cur, word)) {
                        q.offer(word);
                        set.remove(word);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
    
    private boolean canConvert(String cur, String next) {
        int diff = 0;
        
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != (next.charAt(i))) {
                diff++;
            }
        }
        return diff == 1;
    }
    
}