import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N; i > 0; i--) {
            if (levels[i - 1] >= levels[i]) {
                while (levels[i - 1] >= levels[i]) {
                    levels[i - 1]--;
                    count++;
                }
            }
        }
        System.out.println(count);


    }


}