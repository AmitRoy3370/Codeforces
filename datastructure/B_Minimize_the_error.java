import java.util.Scanner;
import java.util.PriorityQueue;

public class B_Minimize_the_error {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k1, k2;
	
	static long a[], b[];
	
	static void solve() {
		
		long diff[] = new long[n];
		
		long sum = 0L;
		
		PriorityQueue<element> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; ++i) {
			
			diff[i] = (a[i] - b[i]) * (a[i] - b[i]);
			
			pq.add(new element(Math.abs(a[i] - b[i]), i));
			
			sum += diff[i];
			
		}
		
		if(k1 == 0 && k2 == 0) {
			
			System.out.println(sum);
			
			return;
			
		}
		
		int total = k1 + k2;
		
		while(total-- > 0) {
			
			element e = pq.poll();
			
			e.diff--;
			
			e.diff = Math.abs(e.diff);
			
			pq.add(e);
			
		}
		
		long ans = 0L;
		
		while(!pq.isEmpty()) {
			
			element e = pq.poll();
			
			ans += e.diff * e.diff;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		k1 = in.nextInt();
		
		k2 = in.nextInt();
		
		a = new long[n];
		
		b = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	static class element implements Comparable<element> {
		
		long diff;
		
		int i;
		
		public element(long diff, int i) {
			
			this.diff = diff;
			this.i = i;
			
		}
		
		@Override
		public int compareTo(element e) {
			
			if(this.diff > e.diff) {
				
				return -1;
				
			} else if(this.diff < e.diff) {
				
				return 1;
				
			}
			
			return 0;
			
		}
		
	}
	
}