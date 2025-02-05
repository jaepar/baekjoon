import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] paper;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> answer = new ArrayList<>();
    static int area, max = 0;

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visit[i][j]) {
                    num++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(num);
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        visit[x][y] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        area = 0;

        while (!q.isEmpty()) {
            area++;
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int now_x = pos.x + dx[i];
                int now_y = pos.y + dy[i];

                if (now_x >= 0 && now_y >= 0 && now_x < n && now_y < m) {
                    if (paper[now_x][now_y] == 1 && !visit[now_x][now_y]) {
                        visit[now_x][now_y] = true;
                        q.add(new Pos(now_x, now_y));
                    }
                }
            }

        }
        max = Math.max(max, area);
    }

}