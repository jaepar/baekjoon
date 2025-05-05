import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        blocks = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int rain = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, blocks[j]);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, blocks[j]);
            }

            if (left > blocks[i] && right > blocks[i]) {
                rain += Math.min(right, left) - blocks[i];
            }
        }

        System.out.println(rain);
    }
}