import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Coffee_Break {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, d;
	
	static long m;
	
	static long a[];
	
	static void solve() {
		
		List<element> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			list.add(new element(a[i], i));
			
		}
		
		Collections.sort(list);
		
		PriorityQueue<element> pq = new PriorityQueue<>();
		
		pq.add(list.get(0));
		
		int day = 2;
		
		long ans[] = new long[n];
		
		//int k = 2;
		
		ans[list.get(0).index] = 1L; 
		
		for(int i = 1; i < n; ++i) {
			
			element e = pq.peek();
			
			if(list.get(i).element - e.element  > d) {
				
				ans[list.get(i).index] = ans[e.index];
				pq.poll();
				
			} else {
				
				ans[list.get(i).index] = day;
				++day;
				
			}
			
			pq.add(list.get(i));
			
		}
		
		System.out.println(--day);
		
		for(long i : ans) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		m = in.nextLong();
		
		d = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	static class element implements Comparable<element>{
		
		long element;
		int index;
		
		public element(long element, int index) {
			
			this.element = element;
			this.index = index;
			
		}
		
		@Override
		public int compareTo(element e) {
			
			if(this.element > e.element) {
				
				return 1;
				
			} else if(this.element < e.element) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}