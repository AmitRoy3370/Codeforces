import java.util.Scanner;

public class E_Block_Sequence {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		long dp[] = new long[n + 2];
		
		dp[n] = 1;
		
		for(int i = n - 1; i >= 1; --i) {
			
			if(a[i] > n - i) {
				
				dp[i] = dp[i + 1] + 1L;
				
			} else {
				
				dp[i] = Math.min(dp[i + a[i] + 1], dp[i + 1] + 1);
				
			}
			
		}
		
		System.out.println(dp[1]);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}