import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String title = "" + i;

            if (title.contains("666")) {
                list.add(i);
            }

            if(list.size() > 10000)
                break;
        }
        bw.write(String.valueOf(list.get(N - 1)));
        bw.flush();
    }
}