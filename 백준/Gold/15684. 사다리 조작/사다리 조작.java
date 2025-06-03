import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, result;
    static int[][] map;
    static boolean finish = false;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            result = i;
            dfs(1, 0);
            if (finish)
                break;
        }
        System.out.println(finish ? result : -1);
    }

    static void dfs(int x, int count) {
        if (finish)
            return;

        if (result == count) {
            if (check())
                finish = true;
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < H; j++) {
                if (map[x][y] == 1)
                    y++;
                else if (map[x][y] == 2)
                    y--;
                x++;
            }
            if (y != i)
                return false;
        }
        return true;
    }

}