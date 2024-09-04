// Problem: C. The Legend of Freya the Frog
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class C_The_Legend_of_Freya_the_Frog {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long x, y, k;
	
	static void solve() {
		
		long moves = (x + k - 1) / k * 2 - 1;
		
		moves = Math.max(moves, (y + k - 1) / k * 2);
		
		System.out.println(moves);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.nextLong();
		y = in.nextLong();
		k = in.nextLong();
		
	}
	
}