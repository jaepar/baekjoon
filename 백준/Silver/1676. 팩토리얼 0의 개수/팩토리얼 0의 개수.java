import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count;

        int mul_5 = N/5;
        int mul_25 = N/25;
        int mul_125 = N/125;

        count = mul_5 + mul_25 + mul_125;

        bw.write(String.valueOf(count));
        bw.flush();
    }
}