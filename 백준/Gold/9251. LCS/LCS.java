import java.io.*;
import java.util.*;

public class Main {
    static char[] line1, line2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        line1 = br.readLine().toCharArray();
        line2 = br.readLine().toCharArray();

        int line1_length = line1.length;
        int line2_length = line2.length;

        int[][] map = new int[line2_length + 1][line1_length + 1];

        for (int i = 1; i <= line1_length; i++) {
            for (int j = 1; j <= line2_length; j++) {
                if (line1[i - 1] == line2[j - 1]) {
                    map[j][i] = map[j - 1][i - 1] + 1;
                }
                else{
                    map[j][i] = Math.max(map[j - 1][i], map[j][i - 1]);
                }
            }
        }

        System.out.println(map[line2_length][line1_length]);
    }

}