import java.io.*;
import java.util.*;

public class Main
{
	static int N, M;
	static int[] tree;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if (tree[i] > max)
				max = tree[i];
		}
		
		int left = 0;
		int right = max;
		int result = 0;
		
		while (left <= right) {
			int mid = left + (right - left)/2;
			
			long cut = 0;
			for (int height : tree) {
				if (height > mid)
					cut += height - mid;
			}
			
			if (cut >= M) {
				result = mid;
				left = mid + 1;
			}
			else if (cut < M) {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
}