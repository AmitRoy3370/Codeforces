// Problem: C. Turtle Fingers: Count the Values of k
// Contest: Codeforces - Codeforces Round 929 (Div. 3)
// URL: https://codeforces.com/contest/1933/problem/C
// Memory Limit: 256 MB
// Time Limit: 5000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class C_Turtle_Fingers_Count_the_Values_of_k {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static int a, b;
	
	static long l;
	
	static void solve() {
		
		Set<Long> set = new HashSet<>();
		
		for(long x = 0; x <= 21; ++x) {
			
			for(long y = 0; y <= 21; ++y) {
				
				long pow1 = pow((long)a, x);
				long pow2 = pow((long)b, y);
				
				if(pow1 > l || pow2 > l || l % pow1 != 0 || l % pow2 != 0) {
					
					continue;
					
				}
				
				long value = pow2 * pow1;
				
				if(l % value != 0) {
					
					continue;
					
				}
				
				set.add(l / value);
				
			}
			
		}
		
		System.out.println(set.size());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextInt();
		b = in.nextInt();
		l = in.nextLong();
		
	}
	
    private static long pow(long value, long power) {
 
        long pow_value = 1L;
 
        while (power > 0L) {
 
            if (power % 2L == 1L) {
 
                pow_value *= value;
 
            }
 
            value *= value;
 
            power /= 2L;
 
        }
 
        return pow_value;
 
    }
    
}