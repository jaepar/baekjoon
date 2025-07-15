import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int resultTime = 0;

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        bfs(sharkX, sharkY);
        System.out.println(resultTime);
    }

    static void bfs(int x, int y) {
        int posX = x;
        int posY = y;
        int ateFish = 0;

        while (true) {
            Queue<Node> q = new LinkedList<>();
            List<Node> eatingList = new ArrayList<>();
            visited = new boolean[N][N];

            visited[posX][posY] = true;
            q.add(new Node(posX, posY, 0));

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1)
                        continue;
                    if (visited[nx][ny])
                        continue;

                    visited[nx][ny] = true;

                    if (map[nx][ny] <= sharkSize) {
                        if (map[nx][ny] < sharkSize && map[nx][ny] > 0) {
                            eatingList.add(new Node(nx, ny, cur.time + 1));
                        }
                        q.add(new Node(nx, ny, cur.time + 1));
                    }
                }
            }
            if (eatingList.size() == 0) {
                break;
            }
            else {
                if (eatingList.size() > 1) {
                    listSort(eatingList);
                }

                Node node = eatingList.get(0);
                resultTime += node.time;
                ateFish++;

                map[posX][posY] = 0;
                posX = node.x;
                posY = node.y;
                map[posX][posY] = 9;

                if (sharkSize == ateFish) {
                    sharkSize++;
                    ateFish = 0;
                }
            }
        }
    }

    static void listSort(List<Node> list) {
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2){
                if (n1.time == n2.time) {
                    if (n1.x == n2.x) {
                        return n1.y - n2.y;
                    } else {
                        return n1.x - n2.x;
                    }
                } else {
                    return n1.time - n2.time;
                }
            }
        });
    }

}