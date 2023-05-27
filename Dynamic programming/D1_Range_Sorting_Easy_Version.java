import java.util.Scanner;

public class D1_Range_Sorting_Easy_Version {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		long dp[][] = new long[n + 1][n + 1];
		
		long cost = 0L;
		
		for(int sub_array_length = 2; sub_array_length <= n; ++sub_array_length) {
			
			for(int left = 1; left + sub_array_length - 1 <= n; ++left) {
				
				int right = left + sub_array_length - 1;
				
				if(a[left] > a[right]) {
					
					dp[left][right] = right - left;
					
				} else {
					
					dp[left][right] = dp[left + 1][right] + dp[left][right - 1] - dp[left + 1][right - 1];
					
				}
				
				cost += dp[left][right];
				
			}
			
		}
		
		System.out.println(cost);
		
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