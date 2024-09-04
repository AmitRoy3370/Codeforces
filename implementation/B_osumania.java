// Problem: B. osu!mania
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_osumania {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static void solve() {
		
		List<Integer> list = new ArrayList<>();
		
		n = in.nextInt();
		
		for(int i = 0; i < n; ++i) {
			
			char x[] = in.next().toCharArray();
			
			for(int j = 0; j < 4; ++j) {
				
				if(x[j] != '.') {
					
					list.add(j + 1);
					break;
					
				}
				
			}
			
		}
		
		Collections.reverse(list);
		
		for(int i : list) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String []amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			solve();
			
		}
		
	}
	
}