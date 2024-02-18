// Problem: A. Maximise The Score
// Contest: Codeforces - think-cell Round 1
// URL: https://codeforces.com/contest/1930/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Arrays;

public class A_Maximise_The_Score {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Arrays.sort(a);
		reverse(a);
		
		long score = 0L;
		
		for(int i = 1; i < 2 * n; i += 2) {
			
			score += a[i];
			
		}
		
		System.out.println(score);
		
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
		
		a = new long[2 * n];
		
		for(int i = 0; i < 2 * n; ++i) {
			
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
	
}