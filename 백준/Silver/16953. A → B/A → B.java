import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int count = 1;

        while (B != A) {
            if (B < A) {
                bw.write("-1");
                bw.flush();
                return;
            }
            String str = String.valueOf(B);

            if (B % 2 == 0) {
                B /= 2;
            } else if (str.charAt(str.length() - 1) == '1') {
                str = str.substring(0, str.length() - 1);
                B = Integer.parseInt(str);
            } else {
                bw.write("-1");
                bw.flush();
                return;
            }

            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}