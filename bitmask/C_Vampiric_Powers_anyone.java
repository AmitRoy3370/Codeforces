import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class C_Vampiric_Powers_anyone {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Set<Long> set = new HashSet<>();
		
		long xor = 0L, max_strength = 0L;;
		
		for(int i = 0; i < n; ++i) {
			
			xor ^= a[i];
			
			max_strength = Math.max(max_strength, xor);
			
			for(long j : set) {
				
				max_strength = Math.max(max_strength, xor ^ j);
				
			}
			
			set.add(xor);
			
		}
		
		System.out.println(max_strength);
		
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