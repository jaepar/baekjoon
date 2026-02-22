import java.io.*;
import java.util.*;

public class Main
{
	static int N;
	static int[][] map;
	static int whiteCnt = 0;
	static int blueCnt = 0;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		sb.append(whiteCnt).append("\n").append(blueCnt);
		System.out.print(sb);
	}
	
	private static void divide(int x, int y, int size) {
		if (check(x, y, size)) {
			if (map[x][y] == 0)
				whiteCnt++;
			else
				blueCnt++;
			
			return;
		}
		
		int half = size / 2;
		
		divide(x, y, half);
		divide(x + half, y, half);
		divide(x, y + half, half);
		divide(x + half, y + half, half);
	}
	
	private static boolean check(int x, int y, int size) {
		int state = map[x][y];
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (map[i][j] != state)
					return false;
			}
		}
		
		return true;
	}
	
}