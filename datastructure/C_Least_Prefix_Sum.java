import java.util.Scanner;
import java.util.PriorityQueue;

public class C_Least_Prefix_Sum {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[];
	
	static void solve() {
		
		PriorityQueue<element> pq = new PriorityQueue<>();
		
		long sum = 0L;
		
		int changes = 0;
		
		for(int i = m + 1; i <= n; ++i) {
			
			sum += a[i];
			
			if(a[i] < 0) {
				
				pq.add(new element(-2L * a[i]));
				
			}
			
			while(sum < 0) {
				
				sum += pq.poll().element;
				
				++changes;
				
			}
			
		}
		
		sum = 0L;
		
		pq = new PriorityQueue<>();
		
		for(int i = m; i > 1; --i) {
			
			sum += a[i];
			
			if(a[i] > 0) {
				
				pq.add(new element(2L * a[i]));
				
			}
			
			while(sum > 0) {
				
				sum -= pq.poll().element;
				
				++changes;
				
			}
			
		}
		
		System.out.println(changes);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			a = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static class element implements Comparable<element> {
		
		long element;
		
		public element(long element) {
			
			this.element = element;
			
		}
		
		public int compareTo(element e) {
			
			if(this.element > e.element) {
				
				return -1;
				
			} else if(this.element < e.element) {
				
				return 1;
				
			}
			
			return 0;
			
		}
		
	}
	
}