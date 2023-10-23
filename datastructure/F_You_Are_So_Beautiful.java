import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class F_You_Are_So_Beautiful {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> prefix = new HashMap<>();
		Map<Long, Integer> suffix = new HashMap<>();
		
		for(int i = 1; i <= n; ++i) {
			
			prefix.put(a[i], i);
			
		}
		
		for(int i = n; i >= 1; --i) {
			
			suffix.put(a[i], i);
			
		}
		
		long first_position[] = new long[n + 1];
		long last_position[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			if(prefix.get(a[i]) == i) {
				
				last_position[i]++;
				
			}
			
			if(suffix.get(a[i]) == i) {
				
				first_position[i]++;
				
			}
			
			last_position[i] += last_position[i - 1];
			
		}
		
		long ans = 0L;
		
		for(int i = 1; i <= n; ++i) {
			
			if(first_position[i] > 0) {
				
				ans += last_position[n] - last_position[i - 1];
			
			}
		
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}