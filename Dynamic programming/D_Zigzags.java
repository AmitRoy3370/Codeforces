import java.util.Scanner;

public class D_Zigzags {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		int dp[][] = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 1; j <= n; ++j) {
				
				if(i == a[j]) {
					
					dp[i][j] = dp[i][j - 1] + 1;
					
				} else {
					
					dp[i][j] = dp[i][j - 1];
					
				}
				
			}
			
		}
		
		long ans = 0;
		
		for(int j = 1; j <= n; ++j) {
			
			for(int k = j + 1; k <= n; ++k) {
				
				int ak = a[k];
				
				int prefix_count = dp[ak][j - 1];
				
				int aj = a[j];
				
				int suffix_count = dp[aj][n] - dp[aj][k];
				
				ans += suffix_count * prefix_count;
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}