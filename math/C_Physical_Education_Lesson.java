// Problem: C. Physical Education Lesson
// Contest: Codeforces - Codeforces Round 924 (Div. 2)
// URL: https://codeforces.com/contest/1928/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class C_Physical_Education_Lesson {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n, x;
	
	static int totalWay(long n, long x) {
		
		int totalK = 0;
		
		for(long i = 1; i * i <= n; ++i) {
			
			if(i * i == n) {
				
				if(i % 2L == 0L && (i + 2L) >= 2L * x) {
					
					++totalK;
					
				}
				
			} else if(n % i == 0L){
				
				long otherPossibleK = n / i;
				
				if(i % 2L == 0L && i + 2L >= 2L * x) {
					
					++totalK;
					
				}
				
				if(otherPossibleK % 2L == 0L && otherPossibleK + 2L >= 2L * x) {
					
					++totalK;
					
				}
				
			}
			
		}
		
		return totalK;
		
	}
	
	static void solve() {
		
		int possibleK = 0;
		
		if(x == 1L) {
			
			possibleK += totalWay(n - x, x + 1L);
			
		} else if(x == 2L) {
			
			if(n % x == 0L) {
				
				++possibleK;
				
			}
			
			possibleK += totalWay(n - x, x + 1L);
			possibleK += totalWay(n + x - 2L, x + 1L);
			
		} else {
			
			if(n % (2L * x - 2L) == x) {
				
				++possibleK;
				
			}
			
			possibleK += totalWay(n - x, x + 1L);
			possibleK += totalWay(n + x - 2L, x + 1L);
			
		}
		
		System.out.println(possibleK);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		x = in.nextLong();
		
	}
	
}