// Problem: A. Make it White
// Contest: Codeforces - Codeforces Round 923 (Div. 3)
// URL: https://codeforces.com/contest/1927/problem/A
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class A_Make_it_White {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int firstBlack = -1, lastBlack = -1;
		
		boolean first = true;
		
		for(int i = 0; i < n; ++i) {
			
			if(first && x[i] == 'B') {
				
				firstBlack = i;
				first = false;
				
			} else if(x[i] == 'B') {
				
				lastBlack = i;
				
			}
			
		}
		
		if(lastBlack == -1) {
			
			lastBlack = firstBlack;
			
		}
		
		if(firstBlack == -1) {
			
			System.out.println(0);
			
		} else {
			
			int segmentLen = lastBlack - firstBlack + 1;
			
			System.out.println(segmentLen);
			
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
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
} 