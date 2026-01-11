import java.io.*;
import java.util.*;

public class Main
{	
	
	static class Jewel {
		int weight;
		int price;
		
		public Jewel(int w, int p) {
			this.weight = w;
			this.price = p;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewels = new Jewel[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			jewels[i] = new Jewel(weight, price);
		}
		
		int[] bag = new int[K];
		
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		// 보석의 무게를 기준으로 오름차순 정렬
		Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));
		
		// 가방의 수용 무게를 기준으로 오름차순 정렬
		Arrays.sort(bag);
		
		// 보석의 가격을 기준으로 내림차순 정렬 하는 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int idx = 0;
		long result = 0;
		
		for (int c : bag) {
			while (idx < N && c >= jewels[idx].weight) {
				pq.add(jewels[idx].price);
				idx++;
			}
			
			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		
		System.out.print(result);
	}
	
}