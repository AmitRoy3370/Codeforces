// Problem: F. Firefly's Queries
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/F
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class F_Firefly_s_Queries {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, q;
	
	static long a[], b[];
	
	static long l[], r[];
	
	static void solve() {
		
		b = new long[2 * n + 1];
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = a[i];
			b[i + n] = a[i];
			
		}
		
		long prefix[] = new long[2 * n + 1];
		
		for(int i = 1; i <= 2 * n; ++i) {
			
			prefix[i] = prefix[i - 1] + b[i - 1];
			
		}
		
		for(int i = 0; i < q; ++i) {
			
			--l[i];
			--r[i];
			
			long sum = prefix[n] * (r[i] / n - l[i] / n - 1);
			sum += prefix[(int)(l[i] / n + n)] - prefix[(int)(l[i] / n + l[i] % n)];
			sum += prefix[(int)(r[i] / n + r[i] % n + 1)] - prefix[(int)(r[i] / n)];
			
			System.out.println(sum);
			
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
		q = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		l = new long[q];
		r = new long[q];
		
		for(int i = 0; i < q; ++i) {
			
			l[i] = in.nextLong();
			r[i] = in.nextLong();
			
		}
		
	}
	
}