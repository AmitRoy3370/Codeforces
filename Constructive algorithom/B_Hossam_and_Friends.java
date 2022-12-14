import java.util.Scanner;

public class B_Hossam_and_Friends {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases, m;
	
	static int x[], y[];
	
	static void solve() {
		
		long dp[] = new long[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			dp[i] = n;
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			int min = Math.min(x[i] - 1, y[i] - 1);
			int max = Math.max(x[i] - 1, y[i] - 1);
			
			long val = dp[min];
			
			dp[min] = Math.min(val, max);
			
		}
		
		long good = 0L;
		
		long max = n;
		
		for(int i = n - 1; i >= 0; --i) {
			
			max = Math.min(max, dp[i]);
			
			good += max - i;
			
		}
		
		System.out.println(Math.abs(good));
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			x = new int[m + 1];
			y = new int[m + 1];
			
			for(int i = 0; i < m; ++i) {
				
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}