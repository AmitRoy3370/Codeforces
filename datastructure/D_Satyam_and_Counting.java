// Problem: D. Satyam and Counting
// Contest: Codeforces - Codeforces Round 971 (Div. 4)
// URL: https://codeforces.com/contest/2009/problem/D
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class D_Satyam_and_Counting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long x[], y[];
	
	static void solve() {
		
		Map<Long, List<Long>> map = new HashMap<>();
		
		for(long i = 0; i < n + 10; ++i) {
			
			List<Long> list = new ArrayList<>();
			
			map.put(i, list);
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			map.get(x[i]).add(y[i]);
			
		}
		
		long triangles = 0L;
		
		long dualTriangle = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			if(map.get(x[i]).contains(1 - y[i]) ) {
				
				triangles += n - 2;
				
			} 
			
			if(
			map.containsKey(x[i] - 1) && 
			map.get(x[i] - 1).contains(1 - y[i]) && 
			map.containsKey(x[i] + 1) && 
			map.get(x[i] + 1).contains(1 - y[i]) ) {
				
				++dualTriangle;
				
			}
			
		}
		
		triangles /= 2L;
		
		triangles += dualTriangle;
		
		System.out.println(triangles);
		
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
		
		x = new long[n];
		y = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			x[i] = in.nextLong();
			y[i] = in.nextLong();
			
		}
		
	}
	
}