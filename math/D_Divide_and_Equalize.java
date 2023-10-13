import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class D_Divide_and_Equalize {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, N = (int)(1e6 + 1);;
	
	static long a[], dp[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			long element = i;
			
			while(element > 1) {
				
				map.put(dp[(int)element], map.getOrDefault(dp[(int)element], 0) + 1);
				
				element /= dp[(int)element];
				
			}
			
		}
		
		boolean yes = true;
		
		for(Integer i : map.values()) {
			
			if(i % n != 0) {
				
				yes = false;
				break;
				
			}
			
		}
		
		if(yes) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		dp();
		
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
	
	private static void dp() {
		
		dp = new long[N + 1];
		
		for(int i = 1; i < N; ++i) {
			
			dp[i] = i;
			
		}
		
		for(int i = 2; i < N; ++i) {
			
			if(dp[i] == i) {
				
				for(int j = i; j < N; j += i) {
					
					dp[j] = i;
					
				}
				
			}
			
		}
		
	}
	
}