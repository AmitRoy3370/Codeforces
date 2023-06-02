import java.util.Scanner;

public class A_Chain_Reaction {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, N = (int)(1e6);
	
	static int postion[];
	
	static long destroy_power[];
	
	static void solve() {
		
		long dp[] = new long[N + 1];
		
		dp[0] = destroy_power[0] > 0 ? 1 : 0;
		
		long minimum_detroy_beacon = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; ++i) {
			
			if(destroy_power[i] == 0) {
				
				dp[i] = dp[i - 1];
				
			} else {
				
				if(destroy_power[i] >= i) {
					
					dp[i] = 1;
					
				} else {
					
					dp[i] = dp[i - (int)destroy_power[i] - 1] + 1;
					
				}
				
			}
			
			minimum_detroy_beacon = Math.max(dp[i], minimum_detroy_beacon);
			
		} 
		
		minimum_detroy_beacon = n - minimum_detroy_beacon;
		
		System.out.println(minimum_detroy_beacon);
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		postion = new int[n];
		
		destroy_power = new long[N + 1];
		
		for(int i = 0; i < n; ++i) {
			
			postion[i] = in.nextInt();
			
			destroy_power[postion[i]] = in.nextLong();
			
		}
		
	}
	
}