import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<Point> q = new LinkedList<>();

    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};

    static class Point {
        int z, x, y;

        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());

                    if (box[z][x][y] == 1) {
                        q.add(new Point(z, x, y));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
    	while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = p.z + dz[i];
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (check(nz, nx, ny)) {
                    box[nz][nx][ny] = box[p.z][p.x][p.y] + 1;
                    q.add(new Point(nz, nx, ny));
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (box[z][x][y] == 0) {
                        return -1;
                    }
                    result = Math.max(result, box[z][x][y]);
                }
            }
        }

        return result == 1 ? 0 : result - 1;
    }

    private static boolean check(int z, int x, int y) {
        if (z < 0 || z >= H || x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        return box[z][x][y] == 0;
    }
}