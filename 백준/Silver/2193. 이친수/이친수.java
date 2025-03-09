import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] binary = new long[N + 1];

        binary[0] = 0;
        binary[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            binary[i] = binary[i - 1] + binary[i - 2];
        }

        System.out.println(binary[N]);
    }

}