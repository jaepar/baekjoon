import java.io.*;
import java.util.*;

public class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N + 1];
		int dp[] = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		dp[1] = num[1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + num[i];
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int result = dp[y] - dp[x - 1];
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
	
}