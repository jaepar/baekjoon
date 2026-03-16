import java.io.*;
import java.util.*;

public class Main
{
	static int N, M;
	static Set<String> set = new LinkedHashSet<>();
	static int[] answer;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		
		dfs(0);
		
		set.forEach(System.out::println);
	}
	
	static private void dfs(int n) {
		
		if (n == M) {
			String tmp = "";
			
			for (int num : answer) {
				tmp += num + " ";
			}
			set.add(tmp);
			
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			{
				if (n > 0 && i < answer[n - 1]) {
					continue;
				}
				answer[n] = i;
				dfs(n + 1);
			}
			
		}
		
	}

}