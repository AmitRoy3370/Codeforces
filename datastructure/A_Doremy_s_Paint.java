import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Doremy_s_Paint {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		int value = n - 1 - map.size();
		
		String range = 1 + " " + n;
		
		for(int i = 1; i < n; ++i) {
			
			map.put(a[i], map.get(a[i]) - 1);
			
			if(map.get(a[i]) <= 0) {
				
				map.remove(a[i]);
				
			}
			
			int len = n - (i + 1) - map.size();
			
			if(len > value) {
				
				value = len;
				
				range = (i + 1) + " " + n;
				
			}
			
		}
		
		System.out.println(range);
		//System.out.println(value);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}