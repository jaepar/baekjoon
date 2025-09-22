import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> users = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], i);
        }
        
        Set<String> reports = new HashSet<>(Arrays.asList(report));
        
        Map<String, Integer> reported_count = new HashMap<>();
        for (String str : reports) {
            String[] parts = str.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            reported_count.put(reported, reported_count.getOrDefault(reported, 0) + 1);
        }
        
        Set<String> x_user = new HashSet<>();
        for (Map.Entry<String, Integer> e : reported_count.entrySet()) {
            if (e.getValue() >= k) {
                x_user.add(e.getKey());
            }
        }
        
        for (String str : reports) {
            String[] parts = str.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            if (x_user.contains(reported)) {
                int user_idx = users.get(reporter);
                answer[user_idx]++;
            }
        }
        
        return answer;
    }
}