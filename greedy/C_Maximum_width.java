// Problem: C. Maximum width
// Contest: Codeforces - Codeforces Round 704 (Div. 2)
// URL: https://codeforces.com/contest/1492/problem/C
// Memory Limit: 512 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class C_Maximum_width {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char x[], y[];
	
	static void solve() {
		
		int left[] = new int[m];
		int right[] = new int[m];
		
		for(int i = 0, j = 0; i < n && j < m; ++i, ++j) {
			
			while(i < n && x[i] != y[j]) {
				
				++i;
				
			}
			
			if(j < m) {
			
			   left[j] = i;
			
			}
			
		}
		
		for(int i = n - 1, j = m - 1; i >= 0 && j >= 0; --i, --j) {
			
			while(i >= 0 && x[i] != y[j]) {
				
				--i;
				
			}
			
			if(j >= 0) {
			
			   right[j] = i;
			
			}
			
		}
		
		int max = 0;
		
		for(int i = 0; i < m - 1; ++i) {
			
			max = Math.max(max, right[i + 1] - left[i]);
			
		}
		
		System.out.println(max);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		x = in.next().toCharArray();
		y = in.next().toCharArray();
		
	}
	
}