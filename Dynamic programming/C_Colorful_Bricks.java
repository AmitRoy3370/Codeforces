import java.util.Scanner;

public class C_Colorful_Bricks {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m, k;
	
	static long mod = 998244353;
	
	static void solve() {
		
		long dp[][] = new long[n + 1][k + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 0; j <= k; ++j) {
				
			  if(0 == j) {
				  
				dp[i][j] = m;
				  
			  } else {
				  
				  dp[i][j] = (dp[i - 1][j] % mod + dp[i - 1][j - 1] * (m - 1)) % mod;
				  
			  }
				
			}
			
		}
		
		System.out.print(dp[n][k]);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		
		solve();
		
	}
	
}