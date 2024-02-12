// Problem: B. Equalize
// Contest: Codeforces - Codeforces Round 924 (Div. 2)
// URL: https://codeforces.com/contest/1928/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class B_Equalize {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Set<Long> set = new HashSet<>();
		
		for(long i : a) {
			
			set.add(i);
			
		}
		
		int m = set.size();
		
		long unique[] = new long[m];
		
		int index = 0;
		
		for(long i : set) {
			
			unique[index++] = i;
			
		}
		
		Arrays.sort(unique);
		
		int maxFrequent = 0;
		
		for(int i = 0, j = 0; i < m && j < m; ) {
			
			if(unique[j] - unique[i] < n) {
				
				maxFrequent = Math.max(maxFrequent, j - i + 1);
				
				++j;
				
			} else {
				
				++i;
				
			}
			
		}
		
		System.out.println(maxFrequent);
		
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