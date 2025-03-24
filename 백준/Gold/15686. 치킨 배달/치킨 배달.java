import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] city;
    static ArrayList<Node> home;
    static ArrayList<Node> chicken;
    static boolean[] live;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    home.add(new Node(i, j));
                }
                if (city[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        live = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            int temp_result = 0;

            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (live[j]) {
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        temp = Math.min(dist, temp);
                    }
                }
                temp_result += temp;
            }
            result = Math.min(result, temp_result);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            live[i] = true;
            dfs(i + 1, cnt + 1);
            live[i] = false;
        }

    }

}