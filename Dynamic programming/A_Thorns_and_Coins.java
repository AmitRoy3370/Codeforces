import java.util.Scanner;

public class A_Thorns_and_Coins {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		long dp[] = new long[n + 2];
		
		int a[] = new int[n + 1];
		
		for(int i = 1; i != n + 1; ++i) {
			
			a[i] = x[i - 1] == '@' ? 1 : x[i - 1] == '.' ? 0 : -1;
			
		}
		
		for(int i = 2; i != n + 1; ++i) {
			
			if(a[i] == -1) {
				
				dp[i] = Integer.MIN_VALUE;
				continue;
				
			}
			
			if(dp[i - 1] == Integer.MIN_VALUE && dp[i - 2] == Integer.MIN_VALUE) {
				
				break;
				
			}
			
			dp[i] = Math.max(dp[i - 1], a[i] + Math.max(dp[i - 1], dp[i - 2]));
			
		}
		
		long max = dp[0];
		
		for(long i : dp) {
			
			max = Math.max(max, i);
			
		}
		
		dp[n] = max;
		
		System.out.println(dp[n]);
		
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
		
		x = in.next().toCharArray();
		
	}
	
}