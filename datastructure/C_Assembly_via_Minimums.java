import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class C_Assembly_via_Minimums {
	
	static Scanner in = new Scanner(System.in);
	
	static StringBuilder ans = new StringBuilder();
	
	static int testCases, n, m;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		long value = (long)(1e9);
		
		long final_array[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			final_array[i] = value;
			
		}
		
		int index = 0;
		
		int sub_array_cover = n - 1;
		
		PriorityQueue<element> pq = new PriorityQueue<>();
		
		for(long i : map.keySet()) {
			
			pq.add(new element(i, map.get(i)));
			
		}
		
		while(!pq.isEmpty()) {
			
			element e = pq.remove();
			
			final_array[index++] = e.element;
			
			e.count -= sub_array_cover;
			
			if(e.count > 0) {
				
				pq.add(new element(e.element, e.count));
				
			}
			
			--sub_array_cover;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : final_array) {
			
			sb.append(i).append(" ");
			
		}

		ans.append(sb.toString().trim()).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.println(ans.toString().trim());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		m = (n * (n - 1)) / 2;
		
		a = new long[m];
		
		for(int i = 0; i < m; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static class element implements Comparable<element> {
		
		long element;
		int count;
		
		public element(long element, int count) {
			
			this.element = element;
			this.count = count;
			
		}
		
		public int compareTo(element that) {
			
			if(this.element > that.element) {
				
				return 1;
				
			} else if(this.element < that.element) {
				
				return -1;
				
			} else if(this.element == that.element) {
				
				if(this.count > that.count) {
					
					return 1;
					
				} else if(this.count < that.count) {
					
					return -1;
					
				}
				
			}
			
			return 0;
			
		}
		
	}
	
}