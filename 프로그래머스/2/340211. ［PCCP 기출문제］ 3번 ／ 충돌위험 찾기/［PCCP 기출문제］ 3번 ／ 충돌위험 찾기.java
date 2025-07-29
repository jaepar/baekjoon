import java.io.*;
import java.util.*;

class Solution {
    static Queue<Pos>[] move;
    static int n;
    static int answer;
    
    static class Pos {
        int x, y;
        
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        n = routes.length;
        move = new LinkedList[n];
        
        for(int i = 0; i < n; i++){
            move[i] = new LinkedList<>();
        }
        
        func1(points, routes);  // 이동경로 담아두기
        func2();    // 이동하면서 충돌횟수 계산
        
        
        return answer;
    }
    
    private void func2() {
        int finish = 0;
        
        while (finish < n){
            int[][] map = new int[101][101];
            finish = 0;
            
            for(int i = 0; i < n; i++){
                if(move[i].isEmpty()){
                    finish++;
                    continue;
                }
                
                Pos cur = move[i].poll();
                map[cur.x][cur.y]++;
            }
            
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if (map[i][j] > 1){
                        answer++;
                    }
                }
            }
            
        }
    }
    
    private void func1(int[][] points, int[][] routes) {
        for(int i = 0; i < n; i++){
            int[] route = routes[i];
            
            // 출발 포인트 좌표
            int x = points[route[0] - 1][1];    // 열
            int y = points[route[0] - 1][0];    // 행
            
            move[i].add(new Pos(x, y));
            
            // 다음 경로의 포인트 좌표
            for(int j = 1; j < route.length; j++){
                int nextX = points[route[j] - 1][1];    // 열
                int nextY = points[route[j] - 1][0];    // 행
                
                // 행을 우선적으로 위치를 맞춤
                while(nextY != y){
                    if(nextY > y)
                        y++;
                    else
                        y--;
                    
                    move[i].add(new Pos(x, y));
                }
                
                // 행을 목표 포인트에 맞춘 뒤 열 위치를 맞춤
                while(nextX != x){
                    if(nextX > x)
                        x++;
                    else
                        x--;
                    
                    move[i].add(new Pos(x, y));
                }
            }
        }
    }
    
}