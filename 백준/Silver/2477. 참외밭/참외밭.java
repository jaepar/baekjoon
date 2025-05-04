import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int maxWidth = Integer.MIN_VALUE;;
    static int maxHeight = Integer.MIN_VALUE;
    static int maxWidthIndex, maxHeightIndex;
    static int[] length = new int[6];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            if (direction == 1 || direction == 2) {
                if (maxWidth < length[i]) {
                    maxWidth = length[i];
                    maxWidthIndex = i;
                }
            }
            if (direction == 3 || direction == 4) {
                if (maxHeight < length[i]) {
                    maxHeight = length[i];
                    maxHeightIndex = i;
                }
            }
        }

        int sliceWidth = getSliceLength(maxHeightIndex);
        int sliceHeight = getSliceLength(maxWidthIndex);

        int result = ((maxHeight * maxWidth) - (sliceHeight * sliceWidth)) * K;

        System.out.println(result);
    }

    static int getSliceLength(int index) {
        int sliceLength = 0;

        if (index == 0)
            sliceLength = Math.abs(length[index + 1] - length[5]);

        else if (index == 5)
            sliceLength = Math.abs(length[index - 1] - length[0]);

        else
            sliceLength = Math.abs(length[index - 1] - length[index + 1]);

        return sliceLength;
    }

}