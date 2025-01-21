import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int apt[][];
    static boolean visit[][];

    static int[] side_x = {-1, 1, 0, 0};
    static int[] side_y = {0, 0, -1, 1};

    static ArrayList<Integer> result;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        apt = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                apt[i][j] = str.charAt(j) - '0';
            }
        }

        result = new ArrayList<>();
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i : result)
            System.out.println(i);
    }

    public static void dfs(int x, int y) {
        count++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int now_x = x + side_x[i];
            int now_y = y + side_y[i];

            if (now_x >= 0 && now_y >= 0 && now_x < N && now_y < N) {
                if (apt[now_x][now_y] == 1 && !visit[now_x][now_y]) {
                    dfs(now_x, now_y);
                }
            }
        }
    }

}