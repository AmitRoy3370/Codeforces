// Problem: D. Find the Different Ones!
// Contest: Codeforces - Codeforces Round 923 (Div. 3)
// URL: https://codeforces.com/contest/1927/problem/D
// Memory Limit: 256 MB
// Time Limit: 5000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class D_Find_the_Different_Ones {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[];
	
	static int L[], R[];
	
	static void solve() {
		
		int dp[] = new int[n];
		
		dp[n - 1] = n;
		
		for(int i = n - 2; i >= 0; --i) {
			
			if(a[i] == a[i + 1]) {
				
				dp[i] = dp[i + 1];
				
			} else {
				
				dp[i] = i + 1;
				
			}
			
		}
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < m; ++i) {
			
			if(dp[L[i]] > R[i]) {
				
				ans.append("-1").append(" ").append("-1").append("\n");
				
			} else {
				
				ans.append((L[i] + 1)).append(" ").append((dp[L[i]] + 1)).append("\n");
				
			}
			
		}
		
		System.out.print(ans.toString());
		
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
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		m = in.nextInt();
		
		L = new int[m];
		R = new int[m];
		
		for(int i = 0; i < m; ++i) {
			
			L[i] = in.nextInt() - 1;
			R[i] = in.nextInt() - 1;
			
		}
		
	}
	
}