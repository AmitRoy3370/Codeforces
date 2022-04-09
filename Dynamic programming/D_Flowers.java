import java.util.Scanner;

public class D_Flowers {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, k, a, b, len;
	
	private static long dp[];
	
	private static long mod = (long) ((1e9) + 7);
	
	private static void solve() {
		
		for(int i = 0; i < k; ++i) {
			
			dp[i] = 1;
			
		}
		
		for(int i = k; i < len; ++i) {
			
			dp[i] = (dp[i - 1] + dp[i - k]) % mod;
			
		}
		
		for(int i = 1; i < len; ++i) {
			
			dp[i] = (dp[i - 1] + dp[i]) % mod;
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		k = in.nextInt();
		
		dp = new long[(int)(1e5) + 1 ];
		
		len = dp.length;
		
		solve();
		
		for(int i = 0; i < testCases; ++i) {
			
			a = in.nextInt();
			
			b = in.nextInt();
			
			System.out.println((dp[b] - dp[a - 1] + mod) % mod );
			
		}
		
	}
	
}