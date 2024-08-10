import java.util.Scanner;

public class B_Mashmokh_and_ACM {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static long mod = (long)(1e9 + 7);
	
	static void solve() {
		
		long goodSubSequence = 0L;
		
		long dp[][] = new long[k + 1][n + 1];
		
		dp[0][1] = 1L;
		
		for(int t = 1; t <= k; ++t) {
			
			for(int i = 1; i <= n; ++i) {
				
				for(int j = i; j <= n; j += i) {
					
					dp[t][j] += dp[t - 1][i] % mod;
					dp[t][j] %= mod;
					
				}
				
			}
			
		}
		
		for(long i : dp[k]) {
			
			goodSubSequence += i % mod;
			goodSubSequence %= mod;
			
		}
		
		System.out.print(goodSubSequence);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
	}
	
}