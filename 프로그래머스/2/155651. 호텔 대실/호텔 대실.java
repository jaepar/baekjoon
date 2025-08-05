import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));
            
            end += 10;
            
            if (end % 100 >= 60){
                end += 40;
            }
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }
        
        // 대실 시작 시간이 더 빠른 것으로 정렬
        Arrays.sort(bookTime, (x, y) -> {
            return x[0] - y[0];
        });
        
        // 퇴실 시간 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        
        for (int[] book : bookTime) {
            if (pq.isEmpty()) {
                pq.add(book);
            }
            else {
                int[] prev = pq.peek();
                
                if (book[0] >= prev[1]) {
                    pq.poll();
                }
                pq.add(book);
            }
        }
        answer = pq.size();
        
        return answer;
    }
}