// Problem: E. Klee's SUPER DUPER LARGE Array!!!
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/E
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class E_Klee_s_SUPER_DUPER_LARGE_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n, k;
	
	static long sum(long startingValue, long len) {
		
		long sum = 2 * startingValue + (len - 1);
		
		sum *= len;
		
		sum /= 2;
		
		return sum;
		
	}
	
	static void solve() {
		
		long x = Long.MAX_VALUE;
		
		long l = 1, r = n;
		
		while(r > l) {
			
			long mid = (l + r) / 2;
			
			long sum1 = sum(k, mid);
			long sum2 = sum(k + mid, n - mid);
			
			x = Math.min(x, Math.abs(sum1 - sum2));
			
			if(sum2 >= sum1) {
				
				l = mid + 1;
				
			} else {
				
				r = mid;
				
			}
			
		}
		
		System.out.println(x);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		k = in.nextLong();
		
	}
	
}