// Problem: E. Turtle vs. Rabbit Race: Optimal Trainings
// Contest: Codeforces - Codeforces Round 929 (Div. 3)
// URL: https://codeforces.com/contest/1933/problem/E
// Memory Limit: 256 MB
// Time Limit: 5000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class E_Turtle_vs_Rabbit_Race_Optimal_Trainings {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, q;
	
	static long a[], u[];
	
	static int L[];
	
	static long score(long u, long sum) {
		
		return u * sum - (sum * (sum - 1)) / 2;
		
	}
	
	static void solve() {
		
		long prefix[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		} 
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < q; ++i) {
			
			long presentValue = 0L;
			int start = L[i];
			int end = n;
			
			while(end > start) {
				
				int mid = (start + end) / 2;
				
				long section = prefix[mid] - prefix[L[i] - 1];
				
				long score = score(u[i], section);
				
				section = prefix[mid + 1] - prefix[L[i] - 1];
				
				presentValue = score(u[i], section);
				
				if(presentValue > score) {
					
					start = mid + 1;
					
				} else {
					
					end = mid;
					
				}
				
			}
			
			sb.append(start).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		q = in.nextInt();
		
		L = new int[q];
		u = new long[q];
		
		for(int i = 0; i < q; ++i) {
			
			L[i] = in.nextInt();
			u[i] = in.nextLong();
			
		}
		
	}
	
}