// Problem: B. Turtle Math: Fast Three Task
// Contest: Codeforces - Codeforces Round 929 (Div. 3)
// URL: https://codeforces.com/contest/1933/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class B_Turtle_Math_Fast_Three_Task {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long sum = 0L;
		
		for(long i : a) {
			
			sum += i;
			
		}
		
		if(sum % 3L == 0L) {
			
			System.out.println(0);
			
		} else if(sum % 3L == 2L) {
			
			System.out.println(1);
			
		} else {
			
			for(long i : a) {
				
				if(i % 3L == 1L) {
					
					System.out.println(1);
					return;
					
				}
				
			}
			
			System.out.println(2);
			
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
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}