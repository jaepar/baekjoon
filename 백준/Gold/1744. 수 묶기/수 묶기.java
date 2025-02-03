import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());  // 내림차순
        PriorityQueue<Integer> minus = new PriorityQueue<>();   // 오름차순

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                plus.add(num);
            } else
                minus.add(num);
        }

        int sum = 0;
        while (!plus.isEmpty()) {
            int num = plus.poll();
            if (plus.isEmpty()) {
                sum += num;
                break;
            }

            if (num == 1) {
                sum += 1;
            } else if (plus.peek() == 1) {
                sum += num + plus.poll();
            }
            else {
                sum += num * plus.poll();
            }
        }

        while (!minus.isEmpty()) {
            int num = minus.poll();
            if (minus.isEmpty()) {
                sum += num;
                break;
            }
            
            else {
                sum += num * minus.poll();
            }
        }
        System.out.println(sum);
    }

}