import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Move_Back_at_a_Cost {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		List<Long> list = new ArrayList<>();
		
		long min[] = new long[n + 2];
		
		min[n + 1] = (long)(2e18);
		
		for(int i = n; i >= 1; --i) {
			
			min[i] = Math.min(min[i + 1], a[i - 1]);
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			if(a[i - 1] > min[i + 1] || (!pq.isEmpty() && pq.peek() < a[i - 1])) {
				
				pq.add(a[i - 1] + 1);
				
			} else {
				
				list.add(a[i - 1]);
				
			}
			
		}
		
		while(!pq.isEmpty()) {
			
			list.add(pq.poll());
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : list) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}

/*

1
5
10 3 8 2 9

*/