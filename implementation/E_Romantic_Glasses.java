import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class E_Romantic_Glasses {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long sum = 0L;
		
		Map<Long, Boolean> map = new HashMap<>();
		
		map.put(sum, true);
		
		for(int i = 0; i != n; ++i) {
			
			if(i % 2 == 0) {
				
				sum += a[i];
				
			} else {
				
				sum -= a[i];
				
			}
			
			if(map.containsKey(sum)) {
				
				System.out.println("YES");
				return;
				
			} else {
				
				map.put(sum, true);
				
			}
			
		}
		
		System.out.println("NO");
		
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