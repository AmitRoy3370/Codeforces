// Problem: B. Permutation Printing
// Contest: Codeforces - think-cell Round 1
// URL: https://codeforces.com/contest/1930/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class B_Permutation_Printing {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		a = new int[n];
		
		int odd = (n % 2 == 0 ? n - 1 : n), even = 2;
		
		for(int i = 1; i <= n; ++i) {
			
			if(i % 2 == 1) {
				
				a[i - 1] = odd;
				odd -= 2;
				
			} else {
				
				a[i - 1] = even;
				even += 2;
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : a) {
			
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
		
	}
	
}