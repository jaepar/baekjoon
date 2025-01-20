import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class TimeTable implements Comparable<TimeTable> {
        int start;
        int end;

        public TimeTable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeTable o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TimeTable[] arr = new TimeTable[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new TimeTable(start, end);
        }

        Arrays.sort(arr);

        int count = 1;
        int now_end = arr[0].end;
        for (int i = 1; i < N; i++) {
            if (arr[i].start >= now_end) {
                count++;
                now_end = arr[i].end;
            }
        }
        System.out.println(count);

    }
}