import java.util.Scanner;

public class C_Increase_Subarray_Sums {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, x;
	
	static int a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		long dp[] = new long[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			dp[i] = Integer.MIN_VALUE;
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			long sum = 0;
			
			for(int j = i; j < n; j++) {
				
				sum += a[j];
				
				dp[j - i + 1] = Math.max(dp[j - i + 1], sum);
				
			}
			
		}
		
		for(int i = 0; i <= n; ++i) {
			
			long ans1 = 0;
			
			for(int j = 0; j <= n; ++j) {
				
				ans1 = Math.max(ans1, Math.min(i, j) * x + dp[j] );
				
			}
			
			ans.append(ans1).append(" ");
			
		}
		
		ans.append("\n");
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			x = in.nextInt();
			
			a = new int[n + 1];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}