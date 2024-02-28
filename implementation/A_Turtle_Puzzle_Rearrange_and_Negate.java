// Problem: A. Turtle Puzzle: Rearrange and Negate
// Contest: Codeforces - Codeforces Round 929 (Div. 3)
// URL: https://codeforces.com/contest/1933/problem/A
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class A_Turtle_Puzzle_Rearrange_and_Negate {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long sum = 0L;
		
		for(long i : a) {
			
			sum += Math.abs(i);
			
		}
		
		System.out.println(sum);
		
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
		
	}
	
}