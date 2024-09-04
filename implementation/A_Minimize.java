// Problem: A. Minimize!
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class A_Minimize {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b;
	
	static void solve() {
		
		int minValue = Integer.MAX_VALUE;
		
		int result = 0;
		
		for(int c = a; c <= b; ++c) {
			
			int min = (c - a) + (b - c);
			
			if(min < minValue) {
				
				minValue = min;
				result = c;
				
			}
			
		}
		
		System.out.println(minValue);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextInt();
		b = in.nextInt();
		
	}
	
}