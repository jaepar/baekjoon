import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int pack = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                pack += N / 5;
                break;
            } else {
                N -= 3;
                pack++;
            }

            if (N < 0) {
                pack = -1;
            }
        }

        bw.write(String.valueOf(pack));
        bw.flush();
    }
}