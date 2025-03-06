import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    public static int day = 0;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new Node(i, j));
                }
            }
        }

        bfs();

        if (check()) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int now_x = x + dx[i];
                int now_y = y + dy[i];

                if (now_x >= 0 && now_x < N && now_y >= 0 && now_y < M) {
                    if (box[now_x][now_y] == 0) {
                        box[now_x][now_y] = box[x][y] + 1;
                        q.add(new Node(now_x, now_y));
                    }
                }
            }

        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return false;
                day = Math.max(day, box[i][j]);
            }
        }
        return true;
    }
}