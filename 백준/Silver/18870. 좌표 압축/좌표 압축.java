import java.io.*;
import java.util.*;

public class Main
{
	static int N;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] sorted = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sorted = arr.clone();
		Arrays.sort(sorted);
		
		int result = 0;
		
		for (int v : sorted) {
			if (!map.containsKey(v)) {
				map.put(v, result);
				result++;
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
	
}