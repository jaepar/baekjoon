import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.MAX_VALUE;

        StringTokenizer st_minus = new StringTokenizer(br.readLine(), "-");

        while (st_minus.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer st_plus = new StringTokenizer(st_minus.nextToken(), "+");

            while (st_plus.hasMoreTokens()) {
                temp += Integer.parseInt(st_plus.nextToken());
            }

            if (result == Integer.MAX_VALUE) {
                result = temp;
            } else {
                result -= temp;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}