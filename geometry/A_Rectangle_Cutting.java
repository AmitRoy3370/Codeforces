// Problem: A. Rectangle Cutting
// Contest: Codeforces - Codeforces Round 924 (Div. 2)
// URL: https://codeforces.com/contest/1928/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class A_Rectangle_Cutting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long a, b;
	
	static void solve() {
		
		long maxSide = Math.max(a, b);
		long minSide = Math.min(a, b);
		
		boolean yes = false;
		
		if(maxSide % 2L == 0L) {
			
			if(maxSide / 2L != minSide ) {
				
				yes = true;
				
			}
			
		}
		
		if(minSide % 2L == 0L) {
			
			if(minSide / 2L != maxSide) {
				
				yes = true;
				
			}
			
		}
		
		if(yes) {
			
			System.out.println("Yes");
			
		} else {
			
			System.out.println("No");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextLong();
		b = in.nextLong();
		
	}
	
}