import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Geometric_Progression {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	static long k;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Long> left = new HashMap<>();
		
		Map<Long, Long> right = new HashMap<>();
		
		for(long i : a) {
			
			left.put(i, left.getOrDefault(i, 0L) + 1);
			
		}
		
		long ans = 0;
		
		for(long i : a) {
			
			left.put(i, left.get(i) - 1L);
			
			if(i % k == 0) {
				
				ans += left.getOrDefault(i * k, 0L) * right.getOrDefault(i / k, 0L); 
				
			}
			
			right.put(i, right.getOrDefault(i, 0L) + 1L);
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		k = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
}