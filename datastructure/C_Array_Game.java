import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

public class C_Array_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static long k;
	
	static void solve() {
		
		if(k >= 3) {
			
			System.out.println(0);
			return;
			
		}
		
		Arrays.sort(a);
		
		long min = a[0];
		
		for(int i = 0; i != n; ++i) {
			
			for(int j = 0; j != n; ++j) {
				
				if(i == j) {
					
					continue;
					
				}
				
				long diff = Math.abs(a[i] - a[j]);
				
				min = Math.min(min, diff);
				
			}
			
		}
		
		if(k == 1) {
			
			System.out.println(min);
			return;
			
		}
		
		TreeSet<Long> set = new TreeSet<>();
		
		for(int i = 0; i != n; ++i) {
			
			set.add(a[i]);
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			for(int j = 0; j != n; ++j) {
				
				if(i == j) {
					
					continue;
					
				}
				
				long diff = Math.abs(a[i] - a[j]);
				
				min = Math.min(min, diff);
				
				if(set.ceiling(diff) != null) {
					
					min = Math.min(min, set.ceiling(diff) - diff);
					
				}
				
				if(set.floor(diff) != null) {
					
					min = Math.min(min, diff - set.floor(diff));
					
				}
				
			}
			
		}
		
		System.out.println(min);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}