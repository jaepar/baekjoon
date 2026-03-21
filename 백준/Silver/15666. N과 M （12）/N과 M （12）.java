import java.io.*;
import java.util.*;

public class Main
{
	static int N, M;
	static int[] arr;
	static int[] result;
	static Set<String> set = new LinkedHashSet<>(); 
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		set.forEach(System.out::println);
	}
	
	private static void dfs(int n) {
		
		if (n == M) {
			String tmp = "";
			for (int x : result) {
				tmp += x + " ";
			}
			set.add(tmp);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if (n >= 1 && result[n - 1] > arr[i])
				continue;
			
			result[n] = arr[i];
			dfs(n + 1);
		}
		
	}
	
	

}