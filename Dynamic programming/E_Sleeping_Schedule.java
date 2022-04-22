import java.util.Scanner;

public class E_Sleeping_Schedule {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, h, l, r;
	
	static int sleep[];
	
	static int inRange(long x) {
		
		return (x >= l && x <= r) ? 1 : 0;
		
	}
	
	static void solve() {
		
		long dp[][] = new long[n + 1][n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			for(int j = 0; j <= n; ++j) {
				
				dp[i][j] = Long.MIN_VALUE;
				
			}
			
		}
		
		dp[0][0] = 0;
		
		long sum = 0;
		
		for(int i = 0; i < n; ++i) {
			
			sum += sleep[i];
			
			for(int j = 0; j <= n; ++j) {
				
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + inRange((sum - j) % h));
				
				if(j < n) {
					
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + inRange((sum - j - 1) % h ));
					
				}
				
			}
			
		}
		
		long ans = 0;
		
		for(int i = 0; i <= n; ++i) {
			
			ans = Math.max(dp[n][i], ans);
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		h = in.nextInt();
		
		l = in.nextInt();
		
		r = in.nextInt();
		
		sleep = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			sleep[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}