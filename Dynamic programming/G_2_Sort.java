import java.util.Scanner;

public class G_2_Sort {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		long dp[] = new long[n];
		
		for(int i = 0; i < n - 1; ++i) {
			
			dp[i] = (a[i] < 2 * a[i + 1] ? 1: 0);
			
		}
		
		long finalSitution = 0, finalAns = 0;
		
		for(int i = 0; i < k; ++i) {
			
			finalSitution += dp[i];
			
		}
		
		if(finalSitution == k) {
			
			++finalAns;
			
		}
		
		for(int i = k; i < n - 1; ++i) {
			
			finalSitution += dp[i];
			
			finalSitution -= dp[i - k];
			
			if(finalSitution == k) {
				
				++finalAns;
				
			}
			
		}
		
		ans.append(finalAns);
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			k = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}