import java.util.Scanner;

public class D_Running_Miles {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long prefix_dp[] = new long[n + 2];
		
		long suffix_dp[] = new long[n + 2];
		
		prefix_dp[0] = Integer.MIN_VALUE;
		
		suffix_dp[n + 1] = Integer.MIN_VALUE;
		
		for(int i = 1, j = n; i <= n && j >= 1; ++i, --j) {
			
			prefix_dp[i] = Math.max(prefix_dp[i - 1], a[i] + i);
			suffix_dp[j] = Math.max(suffix_dp[j + 1], a[j] - j);
			
		}
		
		long max_score = Integer.MIN_VALUE;
		
		for(int i = 2; i <= n - 1; ++i) {
			
			long score = a[i] + prefix_dp[i - 1] + suffix_dp[i + 1];
			
			max_score = Math.max(max_score, score);
			
		}
		
		System.out.println(max_score);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
        		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}