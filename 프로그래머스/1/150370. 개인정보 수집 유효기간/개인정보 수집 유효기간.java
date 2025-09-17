import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();        
        Map<String, String> map = new HashMap<>();
        
        for (String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], term[1]);
        }
        
        String[] arr = today.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String date = privacy[0];
            
            int type = Integer.parseInt(map.get(privacy[1])) * 28;
            
            String[] dates = date.split("\\.");
            
            int num = (year  - Integer.parseInt(dates[0])) * 28 * 12 
                + (month - Integer.parseInt(dates[1])) * 28 
                + (day - Integer.parseInt(dates[2]));
            
            if (num >= type)
                answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}