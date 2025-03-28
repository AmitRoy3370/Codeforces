import java.util.Scanner;
import java.util.TreeMap;

public class D_Zero_Remainder_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	static long k;
	
	static long a[];
	
	static void solve() {
		
		TreeMap<Long, Integer> map = new TreeMap<>();
		
		for(long i : a) {
			
			if(i % k == 0) {
				
				continue;
				
			}
			
			map.put(k - i % k, map.getOrDefault(k - i % k, 0) + 1);
			
		}
		
		long maxKey = map.isEmpty() ? 0 : k - a[0] % k;
		long maxValue = map.getOrDefault(maxKey, 0);
		
		for(long i : map.keySet()) {
			
			if(map.get(i) >= maxValue) {
				
				maxKey = i;
				maxValue = map.get(i);
				
			}
			
		}
		
		long operations = 1 + k * (maxValue - 1) + maxKey;
		
		operations = Math.max(operations, 0);
		
		System.out.println(operations);
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}