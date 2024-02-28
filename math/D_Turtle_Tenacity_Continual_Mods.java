// Problem: D. Turtle Tenacity: Continual Mods
// Contest: Codeforces - Codeforces Round 929 (Div. 3)
// URL: https://codeforces.com/contest/1933/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class D_Turtle_Tenacity_Continual_Mods {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		List<Long> list = new ArrayList<>();
		
		for(long i : a) {
			
			list.add(i);
			
		}
		
		Collections.sort(list);
		
		int index = 0;
		
		for(long i : list) {
			
			a[index++] = i;
			
		}
		
		int unique = 0;
		
		for(int i = 0; i < n; ++i) {
			
			while(i < n - 1 && a[i] == a[i + 1]) {
				
				++i;
				
			}
			
			++unique;
			
		}
		
		if(unique == 1) {
			
			System.out.println("NO");
			
		} else {
			
			if(a[0] != a[1]) {
				
				System.out.println("YES");
				
			} else {
				
				for(int i = 1; i < n; ++i) {
					
					while(i < n - 1 && a[i] == a[i + 1]) {
						
						++i;
						
					}
					
					if(a[i] % a[0] != 0) {
						
						System.out.println("YES");
						return;
						
					}
					
				} 
				
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
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}