import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class B_Make_Almost_Equal_With_Mod {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static long a[];
	
	static void solve() {
		
		int odd = 0;
		
		for(long i : a) {
			
			if(i % 2L == 1) {
				
				++odd;
				
			}
			
		}
		
		if(odd > 0 && n - odd > 0) {
			
			System.out.println(2);
			
		} else {
			
			long max = a[0];
			
			for(long i : a) {
				
				max = Math.max(i, max);
				
			}
			
			long pow = 2L;
			long base = 2L;
			
			while(max >= base) {
				
				base = (long)Math.pow(2L, pow);
				
				Set<Long> set = new HashSet<>();
				
				for(long i : a) {
					
					set.add(i % base);
					
				}
				
				if(set.size() == 2) {
					
					break;
					
				}
				
				pow++;
				
			}
			
			System.out.println(base);
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}