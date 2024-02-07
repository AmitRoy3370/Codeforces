// Problem: E. Klever Permutation
// Contest: Codeforces - Codeforces Round 923 (Div. 3)
// URL: https://codeforces.com/contest/1927/problem/E
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class E_Klever_Permutation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		long max = n, min = 1L;
		
		long p[] = new long[n];
		
		for(int i = 1; i <= k; ++i) {
			
			for(int j = i; j <= n; j += k) {
				
				if(i % 2 == 1) {
					
					p[j - 1] = min++;
					
				} else {
					
					p[j - 1] = max--;
					
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : p) {
			
			sb.append(i).append(" ");
			
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
		k = in.nextInt();
		
	}
	
}