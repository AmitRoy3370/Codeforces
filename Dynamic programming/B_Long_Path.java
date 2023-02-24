import java.util.Scanner;

public class B_Long_Path {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[];
	
	static long mod = 1000000007L;
	
	static void solve1() {
		
		long dp[] = new long[n + 2];
		
		for(int i = 1; i <= n; ++i) {
			
			dp[i + 1] = 2L * dp[i] + 2L - dp[a[i]] + mod;
			
			dp[i + 1] %= mod;
			
		}
		
		System.out.println(dp[n + 1] % mod);
		
	}
	
	static void solve() {
		
		long dp[] = new long[n + 1];
		
		long sum = 2L + n - 1L;
		
		for(int i = 1; i <= n; ++i) {
			
			dp[i] = 1L;
			
		}
		
		for(int i = 2; i <= n; ++i) {
			
			for(int p = a[i]; p < i; ++p) {
				
				dp[i] += (dp[p] + 1L) % mod;
				
				dp[i] %= mod;
				
			}
			
			sum += dp[i] % mod;
			
			sum %= mod;
			
		}
		
		System.out.println(sum);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		//solve();
		solve1();
		
	}
	
}