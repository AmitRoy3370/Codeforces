import java.util.Scanner;

public class H_Don_t_Blame_Me {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static int a[];
	
	static long mod = (long)(1e9 + 7);
	
	static void solve() {
		
		long dp[] = new long[64];
		
		for(int i : a) {
			
			for(int j = 0; j != 64; ++j) {
				
				dp[i & j] += dp[j];
				dp[i & j] %= mod;
				
			}
			
			dp[i]++;
			dp[i] %= mod;
			
		}
		
		long subSequence = 0L;
		
		for(int i = 0; i != 64; ++i) {
			
			if(Long.bitCount(i) == k) {
				
				subSequence += dp[i];
				subSequence %= mod;
				
			}
			
		}
		
		System.out.println(subSequence);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}