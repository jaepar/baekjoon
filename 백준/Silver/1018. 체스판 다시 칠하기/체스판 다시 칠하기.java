import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] chess;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        chess = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String color = br.readLine();

            for (int j = 0; j < N; j++) {
                if (color.charAt(j) == 'W') {
                    chess[i][j] = true;
                } else {
                    chess[i][j] = false;
                }
            }

        }

        int row = M - 7;
        int col = N - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i, j);
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

    public static void find(int x, int y) {
        int x_end = x + 8;
        int y_end = y + 8;
        int count = 0;

        boolean WB = chess[x][y];

        for (int i = x; i < x_end; i++) {
            for (int j = y; j < y_end; j++) {

                if (chess[i][j] != WB) {
                    count++;
                }
                WB = !WB;
            }
            WB = !WB;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(count, min);
    }
}