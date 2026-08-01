import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] useTicket;
    
    public String[] solution(String[][] tickets) {
        useTicket = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    private void dfs(String[][] tickets, String start, String path, int depth) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!useTicket[i] && tickets[i][0].equals(start)) {
                useTicket[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], depth + 1);
                useTicket[i] = false;
            }
        }
    }
    
}