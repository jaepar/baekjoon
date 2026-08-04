import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        int len = n + m*2 -2;
        int[][] map = new int[len][len];
        
        for (int i = m-1; i < m+n-1; i++) {
            for (int j = m-1; j < m+n-1; j++) {
                map[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (check(map, key, lock)){
                return true;
            }
            rotate(key);
        }
        
        return false;
    }
    
    private void rotate(int[][] key) {
        int keyLen = key.length;
        int[][] temp = new int[keyLen][keyLen];
        
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                temp[i][j] = key[keyLen-j-1][i];
            }
        }
        
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
    
    private boolean check(int[][] map, int[][] key, int[][] lock) {
        int mapLen = map.length;
        int keyLen = key.length;
        int lockLen = lock.length;
        
        for (int i = 0; i < mapLen-keyLen+1; i++) {
            for (int j = 0; j < mapLen-keyLen+1; j++) {
                
                for (int k = 0; k < keyLen; k++) {
                    for (int l = 0; l < keyLen; l++) {
                        map[i+k][j+l] += key[k][l];
                    }
                }
                
                boolean flag = true;
                for (int k = keyLen-1; k < keyLen+lockLen-1; k++) {
                    for (int l = keyLen-1; l < keyLen+lockLen-1; l++) {
                        if (map[k][l] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag)
                        break;
                }
                if (flag)
                    return true;
                
                for (int k = 0; k < keyLen; k++) {
                    for (int l =0; l < keyLen; l++) {
                        map[i+k][j+l] -= key[k][l];
                    }
                }
                    
            }
        }
        return false;
    }
}