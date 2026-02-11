import java.io.*;
import java.util.*;

public class Main
{
	static int N, M;
	static int[] dist = new int[100001];
	static int time = 0;
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bfs(N);
		
		System.out.println(dist[M] - 1);
	}
	
	static private void bfs(int start) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		dist[start] = 1;
		
		while (!qu.isEmpty()) {
			int next = qu.poll();
			
			if (next == M) {
				return;
			}
			
			if (next - 1 >= 0 && dist[next - 1] == 0) {
				dist[next - 1] = dist[next] + 1;
				qu.add(next - 1);
			}
			
			if (next + 1 <= 100000 && dist[next + 1] == 0) {
				dist[next + 1] = dist[next] + 1;
				qu.add(next + 1);
			}
			
			if (next * 2 <= 100000 && dist[next * 2] == 0) {
				dist[next * 2] = dist[next] + 1;
				qu.add(next * 2);
			}
			
		}
		
	}
	
}