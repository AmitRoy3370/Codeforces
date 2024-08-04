import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Submission_Bait {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long max = 0L;
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			max = Math.max(max, i);
			
		}
		
		int count = 0;
		
		for(long i : a) {
			
			if(i == max) {
				
				++count;
				
			} else {
				
				map.put(i, map.getOrDefault(i, 0) + 1);
				
			}
			
		}
		
		if(count % 2 == 1) {
			
			System.out.println("YES");
			
		} else {
			
			for(long i : map.keySet()) {
				
				if(map.get(i) % 2 == 1) {
					
					System.out.println("YES");
					return;
					
				}
				
			}
			
			System.out.println("NO");
			
		}
		
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