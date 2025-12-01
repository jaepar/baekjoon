import java.io.*;
import java.util.*;

public class Main
{	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] jewels = new int[M];
		
		int max = 0;
		
		for (int i = 0; i < M; i++) {
			jewels[i] = Integer.parseInt(br.readLine());
			
			if (jewels[i] > max) {
				max = jewels[i];
			}
		}
		
		int left = 1;
		int right = max;
		int answer = max;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			int childs = 0;
			
			for (int j : jewels) {
				childs += (j % mid != 0 ? j / mid + 1 : j / mid);
				
				if (childs > N)
					break;
			}
			
			if (childs <= N) {
				answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.print(answer);
	}

}