import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class A_Doremy_s_Paint_3 {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		if(map.size() > 2) {
			
			System.out.println("NO");
			
		} else {
			
			Arrays.sort(a);
			
			if(Math.abs(map.get(a[0]) - map.get(a[n - 1])) <= 1) {
				
				System.out.println("YES");
				
			} else {
				
				System.out.println("NO");
				
			}
			
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