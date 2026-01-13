import java.io.*;
import java.util.*;

public class Main
{	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] map, result;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		result = new int[N][M];
		
		int startX = 0;
		int startY = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					startX = i;
					startY = j;
				} else if (map[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		
		bfs(startX, startY);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					sb.append(-1).append(" ");
				} else {
					sb.append(result[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		result[x][y] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						result[nx][ny] = result[cur.x][cur.y] + 1;
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
				
			}
			
		}
		
		
	}
	
}