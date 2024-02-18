// Problem: C. Lexicographically Largest
// Contest: Codeforces - think-cell Round 1
// URL: https://codeforces.com/contest/1930/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Arrays;

public class C_Lexicographically_Largest {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long b[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = a[i] + i + 1;
			
		}
		
		Arrays.sort(b);
		reverse(b);
		
		long largest = Long.MAX_VALUE;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			if(largest > b[i]) {
				
				sb.append(b[i]).append(" ");
				largest = b[i];
				
			} else {
				
				sb.append(--largest).append(" ");
				
			}
			
		} 
		
		System.out.println(sb.toString().trim());
		
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
	
	private static void reverse(long a[]) {
		
		int n = a.length;
		
		for(int i = 0; i < n / 2; ++i) {
			
			swap(a, i, n - i - 1);
			
		}
		
	}
	
	private static void swap(long a[], int i, int j) {
		
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	private static void print(long dp[]) {
		
		for(long i : dp) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}