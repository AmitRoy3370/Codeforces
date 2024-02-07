// Problem: C. Choose the Different Ones!
// Contest: Codeforces - Codeforces Round 923 (Div. 3)
// URL: https://codeforces.com/contest/1927/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class C_Choose_the_Different_Ones {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, k;
	
	static int a[], b[];
	
	static void solve() {
		
		boolean A[] = new boolean[k + 1];
		
		boolean B[] = new boolean[k + 1];
		
		Set<Integer> setA = new HashSet<>();
		
		Set<Integer> setB = new HashSet<>();
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] >= 1 && a[i] <= k) {
				
				A[a[i]] = true;
				
				setA.add(a[i]);
				
			} 
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			if(b[i] >= 1L && b[i] <= k) {
				
				B[b[i]] = true;
				setB.add(b[i]);
				
			}
			
		}
		
		int totalNumberA = 0, totalNumberB = 0;
		
		for(int i = 1; i <= k; ++i) {
			
			if(A[i]) {
				
				++totalNumberA;
				
			}
			
		}
		
		for(int i = 1; i <= k; ++i) {
			
			if(B[i]) {
				
				++totalNumberB;
				
			}
			
		} 
		
		int need = k / 2;
		
		if(totalNumberA < need || totalNumberB < need) {
			
			System.out.println("NO");
			
		} else {
			
			Set<Integer> set = new HashSet<>();
			
			for(int i : setA) {
				
				set.add(i);
				
			}
			
			for(int i : setB) {
				
				set.add(i);
				
			}
			
			if(set.size() == k) {
				
				System.out.println("YES");
				
			} else {
				
				System.out.println("NO");
				
			}
			
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
		m = in.nextInt();
		k = in.nextInt();
		
		a = new int[n];
		b = new int[m];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			b[i] = in.nextInt();
			
		}
		
	}
	
}