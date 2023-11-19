import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class D_Yarik_and_Musical_Notes {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		long pair = 0L;
		
		for(long i : a) {
			
			pair += map.getOrDefault(i, 0);
			
			if(i == 1L) {
				
				pair += map.getOrDefault(2L, 0);
				
			} else if(i == 2L) {
				
				pair += map.getOrDefault(1L, 0);
				
			}
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		System.out.println(pair);
		
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
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}
