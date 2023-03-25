import java.util.Scanner;

public class C_Pie_Rules {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long dp[] = new long[n];
		
		long prefix[] = new long[n];
		
		dp[n - 1] = a[n - 1];
		prefix[n - 1] = a[n - 1];
		
		for(int i = n - 2; i >= 0; --i) {
			
			dp[i] = Math.max(dp[i + 1], a[i] + prefix[i + 1] - dp[i + 1]);
			prefix[i] = prefix[i + 1] + a[i];
			
		}
		
		System.out.println((prefix[0] - dp[0]) + " " + dp[0]);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}