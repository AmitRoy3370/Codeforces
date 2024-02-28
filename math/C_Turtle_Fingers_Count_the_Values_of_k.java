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
	
	static long a, b;
	
	static long l;
	
	static void solve() {
		
		Set<Long> set = new HashSet<>();
		
		for(long x = 0L; x <= 21L; ++x) {
			
			for(long y = 0L; y <= 21L; ++y) {
				
				try {
				
				  long pow1 = pow(a, x);
				  long pow2 = pow(b, y);
				
				  if(pow1 > l || pow2 > l || l % pow1 != 0L || l % pow2 != 0L) {
					
					continue;
					
				  }
				
				  long value = pow2 * pow1;
				
				  //System.out.println(pow1 + " " + pow2);
				
				  if(l % value != 0) {
					
					continue;
					
				  }
				
				  set.add(l / value);
				
				} catch(Exception e) {
				    
				}
				
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
		
		a = in.nextLong();
		b = in.nextLong();
		l = in.nextLong();
		
	}
	
    private static long pow(long value, long power) {
        
        if(power == 0L) {
            
            return 1L;
            
        }
 
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
