import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int I;
    static int[][] chess;
    static boolean[][] visit;
    static int x, y, target_x, target_y;

    static int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
    static int[] dy = {2, 2, -2, -2, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            chess = new int[I][I];
            visit = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(chess[target_x][target_y]).append("\n");
        }
        System.out.println(sb);
    }

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            visit[pos.x][pos.y] = true;

            for (int i = 0; i < 8; i++) {
                int ox = pos.x + dx[i];
                int oy = pos.y + dy[i];

                if (ox >= 0 && oy >= 0 && ox < I && oy < I) {
                    if (!visit[ox][oy]) {
                        q.add(new Pos(ox, oy));
                        chess[ox][oy] = chess[pos.x][pos.y] + 1;
                        visit[ox][oy] = true;
                    }
                }

            }
        }
    }

}