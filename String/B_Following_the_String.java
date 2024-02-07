// Problem: B. Following the String
// Contest: Codeforces - Codeforces Round 923 (Div. 3)
// URL: https://codeforces.com/contest/1927/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;

public class B_Following_the_String {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static char ch[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	static void solve() {
		
		int count[] = new int[26];
		
		int index = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == 0L) {
				
				sb.append(ch[index++]);
				count[ch[index - 1] - 'a']++;
				
			} else {
				
				int find = -1;
				
				for(int j = 0; j < 26; ++j) {
					
					if(count[j] == a[i]) {
						
						find = j;
						break;
						
					}
					
				}
				
				sb.append(ch[find]);
				count[ch[find] - 'a']++;
				
			}
			
		}
		
		System.out.println(sb.toString());
		
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