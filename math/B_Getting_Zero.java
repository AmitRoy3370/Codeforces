// Problem: B. Getting Zero
// Contest: Codeforces - Educational Codeforces Round 126 (Rated for Div. 2)
// URL: https://codeforces.com/problemset/problem/1661/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class B_Getting_Zero {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		long b[] = new long[n];
		int index = 0;
		
		for(long i : a) {
			
			long element = i;
			
			int operations = 20;
			
			for(int add = 0; add <= 15; ++add) {
				
				for(int mul = 0; mul <= 15; ++mul) {
					
					if(((element + add) * Math.pow(2, mul)) % 32768L == 0L) {
						
						operations = Math.min(operations, add + mul);
						
					}
					
				}
				
			}
			
			b[index++] = operations;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : b) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.print(sb.toString().trim());
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
}