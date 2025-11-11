import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            boolean[][] box = new boolean[H][W];
            int countRow = 0;
            int countCol = 0;
            boolean isAllBlack = true;

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    if (line.charAt(j) == '#') {    // 검은색
                        box[i][j] = true;
                    }
                    else {                          // 흰색
                        box[i][j] = false;
                        isAllBlack = false;
                    }
                }
            }

            for (int i = 0; i < H; i++) {
                if(checkRow(i, box))
                    countRow++;
            }

            for (int j = 0; j < W; j++) {
                if (checkCol(j, box))
                    countCol++;
            }

            int result = isAllBlack ? Math.min(countRow, countCol) : countRow + countCol;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkRow(int i, boolean[][] box) {
        for (int j = 0; j < box[i].length; j++) {
            if (!box[i][j])
                return false;
        }
        return true;
    }

    private static boolean checkCol(int j, boolean[][] box) {
        for (int i = 0; i < box.length; i++) {
            if(!box[i][j])
                return false;
        }
        return true;
    }
}