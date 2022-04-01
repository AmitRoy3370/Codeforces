import java.util.Scanner;
import java.util.PriorityQueue;

public class C_Phoenix_and_Towers {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, x;
	
	static int a[];
	
	static void solve() {
		
		if(m > n) {
			
			System.out.println("NO");
			
			return;
			
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		System.out.println("YES");
		
		for(int i = 1; i <= m; ++i) {
			
			pq.add(new Pair(0, i));
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			Pair pair = pq.poll();
			
			pair.first += a[i];
			
			pq.add(pair);
			
			System.out.print(pair.second + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			x = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
	static class Pair implements Comparable<Pair> {
		
		int first, second;
		
		public Pair(int first, int second) {
			
			this.first = first;
			this.second = second;
			
		}
		
		public int compareTo(Pair p) {
			
			return Integer.compare(this.first, p.first);
			
		}
		
	}
	
}