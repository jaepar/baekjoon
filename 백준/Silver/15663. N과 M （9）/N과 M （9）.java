import java.io.*;
import java.util.*;

public class Main
{
	static int N, M;
	static int[] num, answer;
	static Set<String> set;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		answer = new int[M];
		visited = new boolean[N];
		set = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		dfs(0);
		
		set.forEach(System.out::println);
	}
	
	
	private static void dfs(int n) {
		if (n == M) {
			String tmp = "";
			for (int x : answer) {
				tmp += x + " ";
			}
			set.add(tmp);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer[n] = num[i];
				dfs(n + 1);
				visited[i] = false;
			}
			
		}
		
		
	}

}