import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] lab;
    static int[][] copyLab;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int safeZone = Integer.MIN_VALUE;

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

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        lab = new int[N][M];
        copyLab = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(safeZone);
    }

    public static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] =1;
                    dfs(wallCnt + 1);
                    lab[i][j] = 0;
                }
            }
        }

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 2) q.add(new Node(i, j));
            }
        }

        for (int i = 0; i < N; i++) {
            copyLab[i] = lab[i].clone();
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int now_x = x + dx[i];
                int now_y = y + dy[i];

                if (now_x >= 0 && now_x < N && now_y >= 0 && now_y < M) {
                    if (copyLab[now_x][now_y] == 0) {
                        copyLab[now_x][now_y] = 2;
                        q.add(new Node(now_x, now_y));
                    }
                }
            }
        }
        countSafeZone();
    }

    public static void countSafeZone() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyLab[i][j] == 0) {
                    count++;
                }
            }
        }
        safeZone = Math.max(count, safeZone);
    }

}