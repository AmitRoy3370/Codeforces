import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Berry_Jam {
	
	static int testCases, n;
	
	static int a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		int sum[] = new int[2 * n + 1];
		
		int index = 1;
		
		//int dp[] = new int[2 * n + 1];
		
		Map<Integer, Integer> dp = new HashMap<>();
		
		dp.put(0, 0);
		
		for(int i : a) {
			
			sum[index] = sum[index - 1] + (i == 1 ? 1 : -1);
			
			if(index <= n) {
				
				dp.put(sum[index], index);
				
			}
			
			++index;
			
		}
		
		int ans = 2 * n;
		
		for(int i = n; i <= 2 * n; ++i) {
			
			int x = sum[i] - sum[2 * n];
			
			if(dp.containsKey(x) ) {
				
				ans = Math.min(ans, i - dp.getOrDefault(x, 0) );
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[2 * n];
			
			for(int i = 0; i < 2 * n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}