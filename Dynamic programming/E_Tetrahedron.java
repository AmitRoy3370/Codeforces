import java.util.Scanner;

public class E_Tetrahedron {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long mod = (long)((long)(1e9) + (long)7);
	
	static void solve() {
		
		long dp[][] = new long[2][n + 1];
		
		dp[1][0] = 1;
		
		for(int j = 1; j <= n; ++j) {
			
			dp[0][j] = (dp[1][j - 1] % mod + (2 * dp[0][j - 1]) % mod) % mod;
			dp[1][j] = (dp[0][j - 1] * 3) % mod;
			
		}
		
		System.out.print(dp[1][n]);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		solve();
		
	}
	
}